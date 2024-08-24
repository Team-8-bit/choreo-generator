package org.team9432.choreogenerator

import org.team9432.choreogenerator.json.JsonConstraint

abstract class ChoreoConstraint {
    abstract val scope: ConstraintScope
    internal abstract fun toJsonConstraint(): JsonConstraint
}

data class StopPoint(override val scope: ConstraintScope): ChoreoConstraint() {
    override fun toJsonConstraint() = JsonConstraint(scope.elements, "StopPoint")
}

data class StraightLine(override val scope: ConstraintScope): ChoreoConstraint() {
    override fun toJsonConstraint() = JsonConstraint(scope.elements, "StraightLine")
}

data class MaxVelocity(override val scope: ConstraintScope, val velocity: Double): ChoreoConstraint() {
    override fun toJsonConstraint() = JsonConstraint(scope.elements, "MaxVelocity", velocity = velocity)
}