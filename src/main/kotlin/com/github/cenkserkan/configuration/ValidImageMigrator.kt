package com.github.cenkserkan.configuration

import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE_IMAGE
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeImageCleanedRecord
import jakarta.annotation.PostConstruct
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.jooq.DSLContext
import org.jooq.Record2
import org.jooq.impl.DSL.arrayAgg
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.web.client.getForEntity
import java.time.Duration
import java.util.UUID
import java.util.concurrent.atomic.AtomicInteger

@Component
class ValidImageMigrator(private val dslContext: DSLContext) {

    private val restTemplate = RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(300))
        .setReadTimeout(Duration.ofMillis(300)).build()

    private val processedImageCount = AtomicInteger()
    private val numberOfCallsMade = AtomicInteger()

    @PostConstruct
    fun migrate() {
        val recipeImages = dslContext
            .select(
                RECIPE_IMAGE.RECIPE_ID,
                arrayAgg(RECIPE_IMAGE.URL).`as`("urls"),
            )
            .from(RECIPE_IMAGE)
            .groupBy(RECIPE_IMAGE.RECIPE_ID)
            .fetch()
            .map { it.toRecipeImageMap() }
        val recipeIdToDeferredUrls: Map<UUID, List<Deferred<String?>>> = runBlocking {
            recipeImages.flatMap {
                it.map { recipe ->
                    val deferredUrls = recipe.value
                        .map { url ->
                            async(Dispatchers.IO) {
                                try {
                                    val responseCode = restTemplate.getForEntity<String>(url).statusCode
                                    if (responseCode.is2xxSuccessful) {
                                        println("Call# ${numberOfCallsMade.incrementAndGet()}: URL checked successfully!")
                                        url
                                    } else {
                                        println("Call# ${numberOfCallsMade.incrementAndGet()}: URL broken")
                                        null
                                    }
                                } catch (ex: Exception) {
                                    println("Call# ${numberOfCallsMade.incrementAndGet()}: URL broken")
                                    null
                                }
                            }
                        }
                    Pair(recipe.key, deferredUrls)
                }
            }
        }.toMap()

        val recipeImageCleanedRecords = recipeIdToDeferredUrls.flatMap { (recipeId, deferredUrls) ->
            runBlocking {
                deferredUrls.awaitAll()
                    .mapNotNull { it }
                    .mapIndexed { index, url ->
                        RecipeImageCleanedRecord().apply {
                            this.recipeId = recipeId
                            this.priority = index + 1
                            this.url = url
                        }
                    }
                    .onEach { println("processedImageCount: ${processedImageCount.incrementAndGet()} RecipeImageCleanedRecord object with recipeId ${it.recipeId} and url ${it.url} created"); }
            }
        }
        println("Saving new recipeImageRecords...")
        dslContext.batchInsert(recipeImageCleanedRecords).execute()
    }

    private fun Record2<UUID, Array<String>>.toRecipeImageMap() = mapOf<UUID, List<String>>(
        this.component1() to this.component2().toList(),
    )
}
