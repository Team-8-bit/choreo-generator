package org.team9432.choreogenerator

class ConstraintScope private constructor(internal val elements: List<String>) {
    companion object {
        val FIRST = ConstraintScope(listOf("first"))
        val LAST = ConstraintScope(listOf("last"))
        fun atWaypoint(waypoint: Int) = ConstraintScope(listOf(waypoint.toString()))
        fun betweenWaypoints(first: Int, last: Int) = ConstraintScope(listOf(first.toString(), last.toString()))
    }
}