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