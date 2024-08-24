package org.team9432.choreogenerator

import kotlinx.serialization.json.Json
import org.team9432.choreogenerator.json.JsonFile
import org.team9432.choreogenerator.json.JsonPath
import java.io.File

private const val DOCUMENT_VERSION = "v0.4"

class ChoreoFile(private val file: File, val robotConfiguration: ChoreoRobotConfiguration, private val splitTrajectoriesAtStopPoints: Boolean = true, private val usesObstacles: Boolean = false) {
    private val paths = mutableMapOf<String, JsonPath>()

    init {
        assert(file.extension == ".chor") { "Incorrect file extension!" }
    }

    fun outputToFile(rewriteAll: Boolean = false) {
        val jsonFile = JsonFile(DOCUMENT_VERSION, robotConfiguration.getJsonConfiguration(), paths, splitTrajectoriesAtStopPoints, usesObstacles)
        val text = serializer.encodeToString(JsonFile.serializer(), jsonFile)
        file.writeText(text)
    }

    fun addPath(path: ChoreoTrajectory) {
        paths[path.name] = path.getJsonPath()
    }

    private companion object {
        val serializer = Json {
            prettyPrint = true
        }
    }
}
