package org.team9432.choreogenerator.api

import org.team9432.choreogenerator.api.json.ChoreoWaypoint
import org.team9432.lib.unit.Angle
import org.team9432.lib.unit.Length
import org.team9432.lib.unit.inMeters
import org.team9432.lib.unit.inRadians

interface GeneratorWaypoint {
    fun toChoreoWaypoint(): ChoreoWaypoint
}

data class PoseWaypoint(val x: Length, val y: Length, val heading: Angle): GeneratorWaypoint {
    override fun toChoreoWaypoint() = ChoreoWaypoint(x.inMeters, y.inMeters, heading.inRadians, isInitialGuess = false, translationConstrained = true, headingConstrained = true, controlIntervalCount = 0)
}