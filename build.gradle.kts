import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.meta.jaxb.Logging
import org.testcontainers.containers.PostgreSQLContainer

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.testcontainers:postgresql:1.17.5")
    }
}

plugins {
    id("nu.studer.jooq") version "8.1"
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.flywaydb.flyway") version "9.8.1"
    id("org.jlleitschuh.gradle.ktlint") version "11.2.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.github.cenkserkan"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    jooqGenerator("org.postgresql:postgresql:42.5.1")
}

val containerInstance: PostgreSQLContainer<Nothing>? = if ("generateJooq" in project.gradle.startParameter.taskNames) {
    PostgreSQLContainer<Nothing>(
        org.testcontainers.utility.DockerImageName.parse(
            "postgres:14.4-alpine"
        )
    ).apply {
        withDatabaseName("meal_planner")
        start()
    }
} else {
    null
}

flyway {
    url = containerInstance?.jdbcUrl
    user = containerInstance?.username
    password = containerInstance?.password
}

jooq {
    version.set("3.17.5") // default (can be omitted)
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS) // default (can be omitted)

    configurations {
        create("main") { // name of the jOOQ configuration
            generateSchemaSourceOnCompilation.set(false) // default (can be omitted)
            jooqConfiguration.apply {
                logging = Logging.ERROR
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = containerInstance?.jdbcUrl
                    user = containerInstance?.username
                    password = containerInstance?.password
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                        isIncludeIndexes = false
                        excludes = "flyway.*"
                    }
                    target.apply {
                        packageName = "com.github.cenkserkan.infra.adapters.generated"
                        directory = "src/main/java"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

tasks.flywayMigrate.configure {
    val taskNames = project.gradle.startParameter.taskNames
    if ("flyMigrate" in taskNames && "generateJooq" !in taskNames) {
        throw IllegalArgumentException("Flyway migrate is only available for generateJooq task")
    }
}

tasks.named("generateJooq").configure {
    dependsOn(tasks.named("flywayMigrate"))
    doLast {
        containerInstance?.stop()
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
