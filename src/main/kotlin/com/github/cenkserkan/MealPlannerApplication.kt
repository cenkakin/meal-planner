package com.github.cenkserkan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MealPlannerApplication

fun main(args: Array<String>) {
    runApplication<MealPlannerApplication>(*args)
}
