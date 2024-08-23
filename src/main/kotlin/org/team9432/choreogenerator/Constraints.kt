package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.ChoreoConstraint
import org.team9432.choreogenerator.json.ChoreoWaypoint
import org.team9432.lib.unit.Angle
import org.team9432.lib.unit.Length
import org.team9432.lib.unit.inMeters
import org.team9432.lib.unit.inRadians

interface GeneratorConstraint {
    fun toChoreoConstraint(): ChoreoConstraint
}

data class StopPoint(val scope: ChoreoConstraintScope): GeneratorConstraint {
    override fun toChoreoConstraint() = ChoreoConstraint(listOf(scope.get()), "StopPoint")
}