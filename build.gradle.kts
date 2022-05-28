import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.fernandocejas.kotlin.playground"
version = "1.0"

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.6.21"
    application
}

application {
    mainClass.set("$group.MainKt")
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
}

tasks.test { useJUnitPlatform() }
tasks.withType<KotlinCompile>() { kotlinOptions.jvmTarget = "17" }

