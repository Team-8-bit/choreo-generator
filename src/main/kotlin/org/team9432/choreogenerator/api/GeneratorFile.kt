package org.team9432.choreogenerator.api

import kotlinx.serialization.json.Json
import org.team9432.choreogenerator.api.json.ChoreoFile
import org.team9432.choreogenerator.api.json.ChoreoPath
import org.team9432.choreogenerator.api.json.ChoreoRobotConfiguration

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

    fun addPaths(vararg paths: GeneratorPath) {
        paths.forEach { addPath(it) }
    }

    private companion object {
        val serializer = Json {
            prettyPrint = true
        }
    }
}
