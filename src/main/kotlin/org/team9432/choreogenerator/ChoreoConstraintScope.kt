package org.team9432.choreogenerator

object ConstraintScope {
    val FIRST = listOf("first")
    val LAST = listOf("last")
    fun atWaypoint(waypoint: Int) = listOf(waypoint.toString())
    fun betweenWaypoints(first: Int, last: Int) = listOf(first.toString(), last.toString())
}