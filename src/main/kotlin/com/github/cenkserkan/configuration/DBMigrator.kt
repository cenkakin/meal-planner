package com.github.cenkserkan.configuration

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import jakarta.annotation.PostConstruct
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.io.File

@Component
class DBMigrator(private val dslContext: DSLContext) {

    private val objectMapper = jacksonObjectMapper()

    @PostConstruct
    fun migrate() {
        val recipesFile = File(DBMigrator::class.java.getResource("/recipes_ignored.json").file)
        val recipePhotosFile = File(javaClass.getResource("/recipe_photos_ignored.json").file)
//        val recipes = objectMapper.readValue<JsonNode>(recipesFile)
//        val recipePhotos = objectMapper.readValue<JsonNode>(recipePhotosFile)
        println("123")
    }
}
