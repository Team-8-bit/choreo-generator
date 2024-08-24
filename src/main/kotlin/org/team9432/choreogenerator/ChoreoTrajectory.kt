package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.JsonPath

class ChoreoTrajectory private constructor(
    private val waypoints: MutableList<ChoreoWaypoint>,
    private val constraints: MutableList<ChoreoConstraint>,
    val name: String,
    private val usesControlIntervalGuessing: Boolean = true,
    private val defaultControlIntervalCount: Int = 40,
    private val usesDefaultFieldObstacles: Boolean = true,
) {

    companion object {
        fun new(
            name: String, includeDefaultConstraints: Boolean = true,
            usesControlIntervalGuessing: Boolean = true,
            defaultControlIntervalCount: Int = 40,
            usesDefaultFieldObstacles: Boolean = true, block: ChoreoTrajectoryBuilder.() -> Unit,
        ): ChoreoTrajectory {
            val trajectory = ChoreoTrajectoryBuilder(name, usesControlIntervalGuessing, defaultControlIntervalCount, usesDefaultFieldObstacles)
            trajectory.block()
            if (includeDefaultConstraints) {
                trajectory.addConstraint(StopPoint(ConstraintScope.FIRST))
                trajectory.addConstraint(StopPoint(ConstraintScope.LAST))
            }

            return trajectory.build()
        }
    }

    internal fun getJsonPath() = JsonPath(
        waypoints = waypoints.map { it.jsonWaypoint },
        samples = emptyList(),
        trajectoryWaypoints = emptyList(),
        constraints = constraints.map { it.toJsonConstraint() },
        usesControlIntervalGuessing = usesControlIntervalGuessing,
        defaultControlIntervalCount = defaultControlIntervalCount,
        usesDefaultFieldObstacles = usesDefaultFieldObstacles,
        circleObstacles = emptyList(),
        eventMarkers = emptyList(),
        isTrajectoryStale = true,
    )

    class ChoreoTrajectoryBuilder internal constructor(
        private val name: String,
        private val usesControlIntervalGuessing: Boolean = true,
        private val defaultControlIntervalCount: Int = 40,
        private val usesDefaultFieldObstacles: Boolean = true,
    ) {
        private val waypoints = mutableListOf<ChoreoWaypoint>()
        private val constraints = mutableListOf<ChoreoConstraint>()

        fun addPoseWaypoint(position: Position, stopPoint: Boolean = false) = addWaypoint(position.asPoseWaypoint(), stopPoint)
        fun addTranslationWaypoint(position: Position, stopPoint: Boolean = false) = addWaypoint(position.asTranslationWaypoint(), stopPoint)

        private fun addWaypoint(waypoint: ChoreoWaypoint, stopPoint: Boolean): Int {
            waypoints.add(waypoint)

            if (stopPoint) {
                addConstraint(StopPoint(ConstraintScope.atWaypoint(waypoints.lastIndex)))
            }

            return waypoints.lastIndex
        }

        fun addConstraint(constraint: ChoreoConstraint) {
            constraints.add(constraint)
        }

        fun build() = ChoreoTrajectory(waypoints, constraints, name, usesControlIntervalGuessing, defaultControlIntervalCount, usesDefaultFieldObstacles)
    }
}