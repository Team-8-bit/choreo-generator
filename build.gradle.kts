plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    application
}

application {
    mainClass = "org.team9432.crescendo2024.MainKt"
}

group = "org.team9432.lib"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.team9432.lib:robot-lib")

    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")

    testImplementation(kotlin("test", "2.0.0"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}