package org.team9432.crescendo2024

import org.team9432.lib.unit.Length
import org.team9432.lib.unit.feet
import org.team9432.lib.unit.inMeters
import org.team9432.lib.unit.inches

object FieldConstants {
    /**
     * - Robot rotation is always 0 degrees when the front of the robot is facing the red alliance wall
     * - (0,0) coordinate on the far right of the blue driver station wall (as though you were standing behind it)
     * - +x is towards the red alliance wall
     * - +y is towards the left side of the field (again standing behind the blue driver station)
     */
    val lengthY = 26.0.feet + 11.25.inches
    val lengthX = 54.0.feet + 3.25.inches
    val centerY = lengthY / 2
    val centerX = lengthX / 2


    /* -------- Note Positions -------- */

    /** X coordinate of the spike notes. */
    private val spikeNoteXCoordinate = 9.0.feet + 6.0.inches

    /** Y spacing between spike notes. */
    private val spikeNoteYSpacing = 4.0.feet + 9.0.inches

    /** Y spacing between center notes. */
    private val centerNoteYSpacing = 5.0.feet + 6.0.inches

    val blueAmpSpikeNote = Coordinate(spikeNoteXCoordinate, centerY + (spikeNoteYSpacing * 2))
    val blueCenterSpikeNote = Coordinate(spikeNoteXCoordinate, centerY + spikeNoteYSpacing)
    val blueStageSpikeNote = Coordinate(spikeNoteXCoordinate, centerY)
    val centerNoteOne = Coordinate(centerX, centerY + (centerNoteYSpacing * 2))
    val centerNoteTwo = Coordinate(centerX, centerY + (centerNoteYSpacing * 1))
    val centerNoteThree = Coordinate(centerX, centerY + (centerNoteYSpacing * 0))
    val centerNoteFour = Coordinate(centerX, centerY + (centerNoteYSpacing * -1))
    val centerNoteFive = Coordinate(centerX, centerY + (centerNoteYSpacing * -2))

    val speakerYCoordinate = centerY + spikeNoteYSpacing

    data class Coordinate(val x: Length, val y: Length) {
        val isOnField get() = (x.inMeters >= 0 && x.inMeters <= lengthX.inMeters) && (y.inMeters >= 0 && y.inMeters <= lengthY.inMeters)
    }
}