package org.team9432.crescendo2024

import org.team9432.choreogenerator.GeneratorFile
import org.team9432.choreogenerator.json.ChoreoRobotConfiguration
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

    val file = GeneratorFile(OSR2024Config)

    file.addPath(FourNote.FourAndNothing)
    file.addPath(FourNote.ReversedFourAndNothing)

    outputFile.writeText(file.export())
}