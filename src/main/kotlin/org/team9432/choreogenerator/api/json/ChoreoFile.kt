package org.team9432.choreogenerator.api.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChoreoFile(
    @SerialName("version")
    val version: String,
    @SerialName("robotConfiguration")
    val robotConfiguration: ChoreoRobotConfiguration,
    @SerialName("paths")
    val paths: Map<String, ChoreoPath>,
    @SerialName("splitTrajectoriesAtStopPoints")
    val splitTrajectoriesAtStopPoints: Boolean,
    @SerialName("usesObstacles")
    val usesObstacles: Boolean,
)