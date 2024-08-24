package org.team9432.choreogenerator.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class JsonFile(
    @SerialName("version")
    val version: String,
    @SerialName("robotConfiguration")
    val robotConfiguration: JsonRobotConfiguration,
    @SerialName("paths")
    val paths: Map<String, JsonPath>,
    @SerialName("splitTrajectoriesAtStopPoints")
    val splitTrajectoriesAtStopPoints: Boolean,
    @SerialName("usesObstacles")
    val usesObstacles: Boolean,
)