package org.team9432.crescendo2024

import org.team9432.choreogenerator.GeneratorPath

object FourNote {
    val FourAndNothing = GeneratorPath("4AndNothing").apply {
        addWaypoint(Waypoints.FOUR_NOTE_START)
        addWaypoint(Waypoints.FOUR_NOTE_SHOT, stopPoint = true)
        addWaypoint(Waypoints.FOUR_NOTE_AMP_PICKUP)
        addWaypoint(Waypoints.FOUR_NOTE_SHOT, stopPoint = true)
        addWaypoint(Waypoints.FOUR_NOTE_SPEAKER_PICKUP)
        addWaypoint(Waypoints.FOUR_NOTE_SHOT, stopPoint = true)
        addWaypoint(Waypoints.FOUR_NOTE_STAGE_PICKUP)
        addWaypoint(Waypoints.FOUR_NOTE_SHOT, stopPoint = true)
    }
}