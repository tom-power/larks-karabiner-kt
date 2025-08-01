/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.10/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization) // Apply the Kotlin serialization plugin

    `java-library`
    idea
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(libs.pods4k.bom))
    implementation(libs.bundles.pods4k)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlin.reflect)
    implementation("karabiner-kt:core:1.1.2")

    testImplementation(libs.bundles.testing)
    testRuntimeOnly(libs.runtime.junit.platform)

    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation("resources-approval:core:0.1")
}

base {
    archivesName = "larks-karabiner-kt-core"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    withSourcesJar()
}

version = "0.1"

tasks.withType<Jar> {
    manifest {
        attributes["Implementation-Title"] = "larks-karabiner-kt-core"
        attributes["Implementation-Version"] = project.version
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
