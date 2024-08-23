package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.ChoreoConstraint

interface GeneratorConstraint {
    fun toChoreoConstraint(): ChoreoConstraint
}

data class StopPoint(val scope: ChoreoConstraintScope): GeneratorConstraint {
    override fun toChoreoConstraint() = ChoreoConstraint(listOf(scope.get()), "StopPoint")
}