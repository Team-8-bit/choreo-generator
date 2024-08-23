package org.team9432.crescendo2024

import org.team9432.choreogenerator.GeneratorFile
import org.team9432.choreogenerator.json.ChoreoRobotConfiguration
import org.team9432.lib.unit.inMeters
import org.team9432.lib.unit.inches
import java.io.File

val OSR2024Config = ChoreoRobotConfiguration(
    mass = 74.08797700309194,
    rotationalInertia = 6,
    motorMaxTorque = 1.162295081967213,
    motorMaxVelocity = 4800,
    gearing = 5.9,
    wheelbase = 13.75.inches.inMeters,
    trackWidth = 19.75.inches.inMeters,
    bumperLength = 25.75.inches.inMeters,
    bumperWidth = 32.inches.inMeters,
    wheelRadius = 1.92.inches.inMeters
)

fun main() {
    val rootDir = File("src/main/resources/")
    val outputFile = File(rootDir, "output.chor")

    val file = GeneratorFile(OSR2024Config)

    file.addPath(FourNote.FourAndNothing)
    file.addPath(FourNote.ReversedFourAndNothing)

    outputFile.writeText(file.export())
}