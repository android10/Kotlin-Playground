import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val javaVersion = JavaVersion.VERSION_17.majorVersion

group = "com.fernandocejas.kotlin.playground"
version = "1.0"

repositories {
    mavenCentral()
}

plugins {
    // https://kotlinlang.org/docs/jvm-get-started.html#create-an-application
    kotlin("jvm") version "1.9.0"
    application
}

application {
    mainClass.set("$group.MainKt")
}

// https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.3")
}

tasks.test { useJUnitPlatform() }
tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = javaVersion }

