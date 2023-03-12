package com.github.cenkserkan.configuration

import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE
import com.github.cenkserkan.infra.adapters.generated.Tables.RECIPE_IMAGE
import com.github.cenkserkan.infra.adapters.generated.tables.records.RecipeCleanedRecord
import jakarta.annotation.PostConstruct
import org.jooq.DSLContext
import org.springframework.stereotype.Component

// @Component
class PriorityMigrator(private val dslContext: DSLContext) {

    @PostConstruct
    fun migrate() {
        val recipes = dslContext.select(
            RECIPE.TITLE,
            RECIPE_IMAGE.URL,
            RECIPE.FSA_FAT,
            RECIPE.FSA_SALT,
            RECIPE.FSA_SATURATED,
            RECIPE.FSA_SUGAR,
            RECIPE.INSTRUCTIONS,
            RECIPE.ENERGY,
            RECIPE.FAT,
            RECIPE.PROTEIN,
            RECIPE.SALT,
            RECIPE.SATURATED_FAT,
            RECIPE.SUGAR,
            RECIPE.ID,
        )
            .from(RECIPE)
            .join(RECIPE_IMAGE)
            .on(RECIPE.ID.eq(RECIPE_IMAGE.RECIPE_ID).and(RECIPE_IMAGE.PRIORITY.eq(1)))
            .fetch()
            .map {
                RecipeCleanedRecord().apply {
                    this.title = it.component1()
                    this.url = it.component2()
                    this.fsaFat = it.component3()
                    this.fsaSalt = it.component4()
                    this.fsaSaturated = it.component5()
                    this.fsaSugar = it.component6()
                    this.instructions = it.component7()
                    this.energy = it.component8()
                    this.fat = it.component9()
                    this.protein = it.component10()
                    this.salt = it.component11()
                    this.saturatedFat = it.component12()
                    this.sugar = it.component13()
                    this.id = it.component14()
                }.also {
                    println("mapping recipe ${it.component1()}")
                }
            }

        dslContext.batchInsert(recipes).execute()
    }
}
