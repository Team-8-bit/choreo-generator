package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.ChoreoWaypoint
import org.team9432.lib.unit.inMeters
import org.team9432.lib.unit.inRadians

fun interface GeneratorWaypoint {
    fun toChoreoWaypoint(): ChoreoWaypoint
}

fun Position.asPoseWaypoint() =
    GeneratorWaypoint { ChoreoWaypoint(x.inMeters, y.inMeters, heading.inRadians, isInitialGuess = false, translationConstrained = true, headingConstrained = true, controlIntervalCount = 0) }

fun Position.asTranslationWaypoint() =
    GeneratorWaypoint { ChoreoWaypoint(x.inMeters, y.inMeters, heading.inRadians, isInitialGuess = false, translationConstrained = true, headingConstrained = false, controlIntervalCount = 0) }