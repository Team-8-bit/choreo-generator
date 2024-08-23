package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.ChoreoConstraint
import org.team9432.choreogenerator.json.ChoreoPath
import org.team9432.choreogenerator.json.ChoreoWaypoint

class GeneratorPath(
    val name: String,
    includeDefaultConstraints: Boolean = true,
    private val usesControlIntervalGuessing: Boolean = true,
    private val defaultControlIntervalCount: Int = 40,
    private val usesDefaultFieldObstacles: Boolean = true,
) {
    private val waypoints = mutableListOf<ChoreoWaypoint>()
    private val constraints = mutableListOf<ChoreoConstraint>()

    val startingPosition get() = waypoints.first().getPosition()
    val endingPosition get() = waypoints.last().getPosition()

    init {
        if (includeDefaultConstraints) {
            addConstraint(StopPoint(ConstraintScope.FIRST))
            addConstraint(StopPoint(ConstraintScope.LAST))
        }
    }

    fun addPoseWaypoint(position: Position, stopPoint: Boolean = false) = addWaypoint(position.asPoseWaypoint(), stopPoint)
    fun addTranslationWaypoint(position: Position, stopPoint: Boolean = false) = addWaypoint(position.asTranslationWaypoint(), stopPoint)

    private fun addWaypoint(waypoint: GeneratorWaypoint, stopPoint: Boolean): Int {
        waypoints.add(waypoint.toChoreoWaypoint())

        if (stopPoint) {
            addConstraint(StopPoint(ConstraintScope.atWaypoint(waypoints.lastIndex)))
        }

        return waypoints.lastIndex
    }

    fun addConstraint(constraint: GeneratorConstraint) {
        constraints.add(constraint.toChoreoConstraint())
    }

    fun build() = ChoreoPath(
        waypoints = waypoints,
        samples = emptyList(),
        trajectoryWaypoints = emptyList(),
        constraints = constraints,
        usesControlIntervalGuessing = usesControlIntervalGuessing,
        defaultControlIntervalCount = defaultControlIntervalCount,
        usesDefaultFieldObstacles = usesDefaultFieldObstacles,
        circleObstacles = emptyList(),
        eventMarkers = emptyList(),
        isTrajectoryStale = true,
    )
}