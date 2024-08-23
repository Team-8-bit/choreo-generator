package org.team9432.choreogenerator.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChoreoPath(
    @SerialName("waypoints")
    val waypoints: List<ChoreoWaypoint>,
    @SerialName("trajectory")
    val samples: List<ChoreoSample>,
    @SerialName("trajectoryWaypoints")
    val trajectoryWaypoints: List<ChoreoTrajectoryWaypoint>,
    @SerialName("constraints")
    val constraints: List<ChoreoConstraint>,
    @SerialName("usesControlIntervalGuessing")
    val usesControlIntervalGuessing: Boolean,
    @SerialName("defaultControlIntervalCount")
    val defaultControlIntervalCount: Int,
    @SerialName("usesDefaultFieldObstacles")
    val usesDefaultFieldObstacles: Boolean,
    @SerialName("circleObstacles")
    val circleObstacles: List<Nothing>,
    @SerialName("eventMarkers")
    val eventMarkers: List<Nothing>,
    @SerialName("isTrajectoryStale")
    val isTrajectoryStale: Boolean,
)