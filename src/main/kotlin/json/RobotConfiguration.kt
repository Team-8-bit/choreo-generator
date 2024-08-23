package json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RobotConfiguration(
    @SerialName("mass")
    val mass: Double,
    @SerialName("rotationalInertia")
    val rotationalInertia: Int,
    @SerialName("motorMaxTorque")
    val motorMaxTorque: Double,
    @SerialName("motorMaxVelocity")
    val motorMaxVelocity: Int,
    @SerialName("gearing")
    val gearing: Double,
    @SerialName("wheelbase")
    val wheelbase: Double,
    @SerialName("trackWidth")
    val trackWidth: Double,
    @SerialName("bumperLength")
    val bumperLength: Double,
    @SerialName("bumperWidth")
    val bumperWidth: Double,
    @SerialName("wheelRadius")
    val wheelRadius: Double,
)