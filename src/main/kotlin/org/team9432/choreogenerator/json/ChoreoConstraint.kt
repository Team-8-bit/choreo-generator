package org.team9432.choreogenerator.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.*

@Serializable
data class ChoreoConstraint(
    @SerialName("scope")
    @Serializable(with = ScopeSerializer::class)
    val scope: List<String>,
    @SerialName("type")
    val type: String,
)

object ScopeSerializer: JsonTransformingSerializer<List<String>>(ListSerializer(String.serializer())) {
    // If response is not an array, then it is a single object that should be wrapped into the array
    override fun transformDeserialize(element: JsonElement): JsonElement =
        (element as JsonArray).let { array ->
            val it = array.first() as JsonPrimitive
            JsonArray(listOf(JsonPrimitive(it.content)))
        }

    override fun transformSerialize(element: JsonElement): JsonElement {
        return (element as JsonArray).let { array ->
            val it = array.first() as JsonPrimitive
            JsonArray(listOf(it.intOrNull?.let { JsonPrimitive(it) } ?: JsonPrimitive(it.content)))
        }
    }
}