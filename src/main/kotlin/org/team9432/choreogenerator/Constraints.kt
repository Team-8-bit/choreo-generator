package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.ChoreoConstraint

interface GeneratorConstraint {
    fun toChoreoConstraint(): ChoreoConstraint
}

data class StopPoint(val scope: List<String>): GeneratorConstraint {
    override fun toChoreoConstraint() = ChoreoConstraint(scope, "StopPoint")
}

data class StraightLine(val scope: List<String>): GeneratorConstraint {
    override fun toChoreoConstraint() = ChoreoConstraint(scope, "StraightLine")
}

data class MaxVelocity(val scope: List<String>, val velocity: Double): GeneratorConstraint {
    override fun toChoreoConstraint() = ChoreoConstraint(scope, "MaxVelocity", velocity = velocity)
}