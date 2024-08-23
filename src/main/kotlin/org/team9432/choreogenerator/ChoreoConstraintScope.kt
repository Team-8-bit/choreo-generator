package org.team9432.choreogenerator

object ConstraintScope {
    const val FIRST = "first"
    const val LAST = "last"
    fun atWaypoint(waypoint: Int) = waypoint.toString()
    fun betweenWaypoints(waypoints: IntRange) = "${waypoints.first}, ${waypoints.last}"
}