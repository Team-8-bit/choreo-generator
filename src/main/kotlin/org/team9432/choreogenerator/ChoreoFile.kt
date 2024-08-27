package org.team9432.choreogenerator

import kotlinx.serialization.json.Json
import org.team9432.choreogenerator.json.JsonChoreoFile
import org.team9432.choreogenerator.json.JsonPath
import java.io.File

private const val DOCUMENT_VERSION = "v0.4"

class ChoreoFile(private val file: File, val robotConfiguration: ChoreoRobotConfiguration, private val splitTrajectoriesAtStopPoints: Boolean = true, private val usesObstacles: Boolean = false) {
    private val paths = mutableMapOf<String, JsonPath>()

    init {
        assert(file.extension == ".chor") { "Incorrect file extension!" }
    }

    fun outputToFile(rewriteAll: Boolean = false) {
        val outputPaths = mutableMapOf<String, JsonPath>()

        if (!rewriteAll) {
            val existingFile: JsonChoreoFile? = getExistingFile()

            if (existingFile != null) {
                /** The goal here is to assess which paths have changed and set [JsonPath.isTrajectoryStale] in each one accordingly. */

                val existingPaths = existingFile.paths
                val currentPaths = this.paths
                var needsGenerationCount = 0

                for ((name, newPath) in currentPaths) {
                    // If there's no existing path, the new one must be generated
                    val existingPath = existingPaths[name]

                    if (existingPath == null) {
                        outputPaths[name] = newPath
                        needsGenerationCount++
                        printInfo("Added new path: $name and marked for generation")
                        continue
                    }

                    // If there is an existing path, check to see if it needs to be generated
                    if (alreadyGenerated(newPath, existingPath)) {
                        outputPaths[name] = existingPath
                    } else {
                        printInfo("Marked $name for generation")
                        needsGenerationCount++
                        outputPaths[name] = newPath.apply { isTrajectoryStale = true }
                    }
                }

                printInfo("Marked $needsGenerationCount files for generation")
            } else {
                outputPaths.putAll(paths)
            }
        } else {
            outputPaths.putAll(paths)
        }

        val outputFile = JsonChoreoFile(DOCUMENT_VERSION, robotConfiguration.getJsonConfiguration(), outputPaths, splitTrajectoriesAtStopPoints, usesObstacles)

        val text = serializer.encodeToString(JsonChoreoFile.serializer(), outputFile)
        file.writeText(text)
    }

    private fun printInfo(message: String) = println("[Info] $message")

    /** Return true if [newPath] needs to be generated after comparing it to [existingPath]. */
    private fun alreadyGenerated(newPath: JsonPath, existingPath: JsonPath): Boolean {
        val waypointsMatching = newPath.waypoints.size == existingPath.waypoints.size &&
                newPath.waypoints.zip(existingPath.waypoints).all { (first, second) ->
                    first.x == second.x &&
                            first.y == second.y &&
                            first.heading == second.heading &&
                            first.isInitialGuess == second.isInitialGuess &&
                            first.translationConstrained == second.translationConstrained &&
                            first.headingConstrained == second.headingConstrained
                    // We ignore control interval count as that is done by the generator
                    //&& first.controlIntervalCount == second.controlIntervalCount
                }

        val remainingMatching =
            newPath.constraints == existingPath.constraints &&
                    newPath.usesControlIntervalGuessing == existingPath.usesControlIntervalGuessing &&
                    newPath.defaultControlIntervalCount == existingPath.defaultControlIntervalCount &&
                    newPath.usesDefaultFieldObstacles == existingPath.usesDefaultFieldObstacles &&
                    newPath.circleObstacles == existingPath.circleObstacles &&
                    newPath.eventMarkers == existingPath.eventMarkers

        // Samples and TrajectoryWaypoints are both generated by choreo and therefore aren't compared here

        // The path always needs to be generated if it doesn't have any saved samples
        val hasSamples = existingPath.samples.isNotEmpty()

        val isAlreadyStale = existingPath.isTrajectoryStale

        return waypointsMatching && remainingMatching && hasSamples && !isAlreadyStale
    }

    private fun getExistingFile(): JsonChoreoFile? {
        if (!file.exists()) {
            println("No existing file")
        } else {
            try {
                return serializer.decodeFromString<JsonChoreoFile>(file.readText())
            } catch (e: Exception) {
                println("Failed to read existing file ${file.absolutePath}")
                println(e.stackTraceToString())
            }
        }

        return null
    }

    fun addPath(path: ChoreoTrajectory) {
        paths[path.name] = path.getJsonPath()
    }

    fun addPaths(paths: Collection<ChoreoTrajectory>) {
        paths.forEach { addPath(it) }
    }

    private companion object {
        val serializer = Json {
            prettyPrint = true
        }
    }
}
