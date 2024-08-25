package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.JsonConstraint

abstract class ChoreoConstraint {
    internal abstract val jsonConstraint: JsonConstraint
}

data class StopPoint(val waypoint: Int): ChoreoConstraint() {
    override val jsonConstraint = JsonConstraint(setOf(waypoint.toString()), "StopPoint")
}

data object InitialStopPoint: ChoreoConstraint() {
    override val jsonConstraint = JsonConstraint(setOf("first"), "StopPoint")
}

data object FinalStopPoint: ChoreoConstraint() {
    override val jsonConstraint = JsonConstraint(setOf("last"), "StopPoint")
}

data class StraightLine(val startWaypoint: Int, val endWaypoint: Int = startWaypoint): ChoreoConstraint() {
    override val jsonConstraint = JsonConstraint(setOf(startWaypoint.toString(), endWaypoint.toString()), "StraightLine")
}

data class MaxVelocity(val startWaypoint: Int, val endWaypoint: Int = startWaypoint, val velocity: Double): ChoreoConstraint() {
    override val jsonConstraint = JsonConstraint(setOf(startWaypoint.toString(), endWaypoint.toString()), "MaxVelocity", velocity = velocity)
}