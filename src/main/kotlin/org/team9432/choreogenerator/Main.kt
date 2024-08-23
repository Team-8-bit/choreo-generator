package org.team9432.choreogenerator

import org.team9432.choreogenerator.api.GeneratorFile
import org.team9432.choreogenerator.api.GeneratorPath
import org.team9432.choreogenerator.api.PoseWaypoint
import org.team9432.choreogenerator.api.json.ChoreoRobotConfiguration
import org.team9432.lib.unit.degrees
import org.team9432.lib.unit.meters
import java.io.File

val OSR2024Config = ChoreoRobotConfiguration(
    mass = 74.08797700309194,
    rotationalInertia = 6,
    motorMaxTorque = 1.162295081967213,
    motorMaxVelocity = 4800,
    gearing = 5.9,
    wheelbase = 0.5016497291091463,
    trackWidth = 0.5016497291091463,
    bumperLength = 0.8762995267982555,
    bumperWidth = 0.8762995267982555,
    wheelRadius = 0.048767973665294215
)

fun main() {
    val rootDir = File("src/main/resources/")
    val outputFile = File(rootDir, "output.chor")

    val generatorFile = GeneratorFile(OSR2024Config)

    val testPath = GeneratorPath("Test path")

    testPath.addWaypoint(PoseWaypoint(x = 0.meters, y = 0.meters, heading = 0.degrees))
    testPath.addWaypoint(PoseWaypoint(x = 5.meters, y = 5.meters, heading = 180.degrees))

    generatorFile.addPath(testPath)

    outputFile.writeText(generatorFile.export())
}