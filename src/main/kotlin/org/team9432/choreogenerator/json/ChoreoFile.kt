package org.team9432.choreogenerator.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChoreoFile(
    @SerialName("version")
    val version: String,
    @SerialName("robotConfiguration")
    val robotConfiguration: RobotConfiguration,
    @SerialName("paths")
    val paths: Map<String, Path>,
    @SerialName("splitTrajectoriesAtStopPoints")
    val splitTrajectoriesAtStopPoints: Boolean,
    @SerialName("usesObstacles")
    val usesObstacles: Boolean,
)