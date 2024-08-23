package org.team9432.choreogenerator.api

fun interface ChoreoConstraintScope {
    fun get(): String

    companion object {
        val FIRST = ChoreoConstraintScope { "first" }
        val LAST = ChoreoConstraintScope { "last" }

        fun atWaypoint(waypoint: Int) = ChoreoConstraintScope { waypoint.toString() }
    }
}