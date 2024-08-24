plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "org.team9432.lib"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.team9432.lib:robot-lib")

    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
    maven { setUrl("https://frcmaven.wpi.edu/artifactory/release/") }
    maven { setUrl("https://plugins.gradle.org/m2/") }
    maven { setUrl("https://maven.ctr-electronics.com/release/") }
    maven { setUrl("https://maven.revrobotics.com/") }
    maven { setUrl("https://maven.photonvision.org/repository/internal") }
    maven { setUrl("https://maven.photonvision.org/repository/snapshots") }
    maven { setUrl("https://jitpack.io") }
    maven { setUrl("https://SleipnirGroup.github.io/ChoreoLib/dep") }
}