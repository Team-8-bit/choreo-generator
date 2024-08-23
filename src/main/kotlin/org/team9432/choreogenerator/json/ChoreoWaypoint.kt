package org.team9432.choreogenerator.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.team9432.choreogenerator.Position
import org.team9432.lib.unit.meters
import org.team9432.lib.unit.radians

@Serializable
data class ChoreoWaypoint(
    @SerialName("x")
    val x: Double,
    @SerialName("y")
    val y: Double,
    @SerialName("heading")
    val heading: Double,
    @SerialName("isInitialGuess")
    val isInitialGuess: Boolean,
    @SerialName("translationConstrained")
    val translationConstrained: Boolean,
    @SerialName("headingConstrained")
    val headingConstrained: Boolean,
    @SerialName("controlIntervalCount")
    val controlIntervalCount: Int,
) {
    fun getPosition() = Position(x.meters, y.meters, heading.radians)
}