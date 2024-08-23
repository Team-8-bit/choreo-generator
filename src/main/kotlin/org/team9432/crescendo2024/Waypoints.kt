package org.team9432.crescendo2024

import org.team9432.choreogenerator.PoseWaypoint
import org.team9432.lib.unit.degrees
import org.team9432.lib.unit.meters
import org.team9432.lib.unit.radians

object Waypoints {
    val FOUR_NOTE_SHOT = PoseWaypoint(1.7.meters, FieldConstants.speakerYCoordinate, 180.0.degrees)
    val FOUR_NOTE_START = PoseWaypoint(1.34.meters, FieldConstants.speakerYCoordinate, 180.0.degrees)
    val FOUR_NOTE_AMP_PICKUP = PoseWaypoint(2.7.meters, 7.meters, (-2.65).radians)
    val FOUR_NOTE_SPEAKER_PICKUP = PoseWaypoint(2.88.meters, FieldConstants.speakerYCoordinate, 180.0.degrees)
    val FOUR_NOTE_STAGE_PICKUP = PoseWaypoint(2.64.meters, 4.22.meters, 2.71.radians)
}