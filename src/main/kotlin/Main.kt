package org.team9432

import json.ChoreoFile
import kotlinx.serialization.json.Json
import java.io.File

val serializer = Json {
    prettyPrint = true
}

fun main() {
    val rootDir = File("src/main/resources/")
    val originalFile = File(rootDir, "test.chor").readText()
    val outputFile = File(rootDir, "output.chor")

    val decodedFile = serializer.decodeFromString<ChoreoFile>(originalFile)
    val reencodedFile = serializer.encodeToString(ChoreoFile.serializer(), decodedFile)
    println(reencodedFile)
    println(originalFile == reencodedFile)
    outputFile.writeText(reencodedFile)
}