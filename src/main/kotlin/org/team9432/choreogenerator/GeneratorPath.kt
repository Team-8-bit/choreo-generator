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

    init {
        if (includeDefaultConstraints) {
            addConstraint(StopPoint(ChoreoConstraintScope.FIRST))
            addConstraint(StopPoint(ChoreoConstraintScope.LAST))
        }
    }

    fun addWaypoint(waypoint: GeneratorWaypoint) {
        waypoints.add(waypoint.toChoreoWaypoint())
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