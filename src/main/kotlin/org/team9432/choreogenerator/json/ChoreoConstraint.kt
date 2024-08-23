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
        JsonArray((element as JsonArray).map { it as JsonPrimitive })

    override fun transformSerialize(element: JsonElement): JsonElement {
        return JsonArray((element as JsonArray).map { it as JsonPrimitive }.map { scope -> scope.intOrNull?.let { JsonPrimitive(it) } ?: JsonPrimitive(scope.content) })
    }
}