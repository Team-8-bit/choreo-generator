package org.team9432.choreogenerator

import kotlinx.serialization.json.Json
import org.team9432.choreogenerator.json.ChoreoFile
import org.team9432.choreogenerator.json.ChoreoPath
import org.team9432.choreogenerator.json.ChoreoRobotConfiguration

private const val DOCUMENT_VERSION = "v0.4"

class GeneratorFile(val robotConfiguration: ChoreoRobotConfiguration, private val splitTrajectoriesAtStopPoints: Boolean = true, private val enableUIObstacles: Boolean = false) {
    private val paths = mutableMapOf<String, ChoreoPath>()

    fun export(): String {
        val file = ChoreoFile(DOCUMENT_VERSION, robotConfiguration, paths, splitTrajectoriesAtStopPoints, usesObstacles = enableUIObstacles)

        return serializer.encodeToString(ChoreoFile.serializer(), file)
    }

    fun addPath(path: GeneratorPath) {
        paths[path.name] = path.build()
    }

    private companion object {
        val serializer = Json {
            prettyPrint = true
        }
    }
}
