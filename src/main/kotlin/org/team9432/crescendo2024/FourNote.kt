package org.team9432.crescendo2024

import org.team9432.choreogenerator.*
import org.team9432.lib.unit.degrees
import org.team9432.lib.unit.meters

object FourNote {
    private val FOUR_NOTE_START = Position(1.34.meters, FieldConstants.speakerYCoordinate, 180.0.degrees)
    private val FOUR_NOTE_SHOT = Position(1.7.meters, FieldConstants.speakerYCoordinate, 180.0.degrees)
    private val FOUR_NOTE_AMP_ALIGN = FieldConstants.ampNote.copy().moveTowards(FOUR_NOTE_SHOT, 0.75.meters).pointAwayFrom(FieldConstants.ampNote)
    private val FOUR_NOTE_AMP_PICKUP = FieldConstants.ampNote.copy().moveTowards(FOUR_NOTE_SHOT, 0.15.meters).pointAwayFrom(FieldConstants.ampNote)
    private val FOUR_NOTE_SPEAKER_PICKUP = Position(2.88.meters, FieldConstants.speakerYCoordinate, 180.0.degrees)
    private val FOUR_NOTE_STAGE_ALIGN = FieldConstants.stageNote.copy().moveX(-0.6.meters).pointAwayFrom(FieldConstants.stageNote)
    private val FOUR_NOTE_STAGE_PICKUP = FieldConstants.stageNote.copy().moveX(-0.2.meters).pointAwayFrom(FieldConstants.stageNote)
    private val FOUR_NOTE_STAGE_EXIT = FieldConstants.stageNote.copy().moveX(-0.5.meters).moveY(0.5.meters).rotateBy(180.degrees)//.pointAwayFrom(FieldConstants.stageNote)

    val FourAndNothing = GeneratorPath("4AndNothing").apply {
        preload()
        amp()
        speaker()
        stage()
    }

    val ReversedFourAndNothing = GeneratorPath("4AndNothingReversed").apply {
        preload()
        stage()
        speaker()
        amp()
    }

    private fun GeneratorPath.preload() {
        addPoseWaypoint(FOUR_NOTE_START)
        addPoseWaypoint(FOUR_NOTE_SHOT, stopPoint = true)
    }

    private fun GeneratorPath.amp() {
        addPoseWaypoint(FOUR_NOTE_AMP_ALIGN)
        addPoseWaypoint(FOUR_NOTE_AMP_PICKUP)
        addPoseWaypoint(FOUR_NOTE_SHOT, stopPoint = true)
    }

    private fun GeneratorPath.speaker() {
        addPoseWaypoint(FOUR_NOTE_SPEAKER_PICKUP)
        addPoseWaypoint(FOUR_NOTE_SHOT, stopPoint = true)
    }

    private fun GeneratorPath.stage() {
        val straightLineStart = addPoseWaypoint(FOUR_NOTE_STAGE_ALIGN)
        val straightLineEnd = addPoseWaypoint(FOUR_NOTE_STAGE_PICKUP)
        addConstraint(StraightLine(ConstraintScope.betweenWaypoints(straightLineStart..straightLineEnd)))
        addTranslationWaypoint(FOUR_NOTE_STAGE_EXIT)
        addPoseWaypoint(FOUR_NOTE_SHOT, stopPoint = true)
    }
}