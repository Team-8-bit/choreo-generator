package org.team9432.choreogenerator.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Path(
    @SerialName("waypoints")
    val waypoints: List<Waypoint>,
    @SerialName("trajectory")
    val samples: List<Sample>,
    @SerialName("trajectoryWaypoints")
    val trajectoryWaypoints: List<TrajectoryWaypoint>,
    @SerialName("constraints")
    val constraints: List<Constraint>,
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