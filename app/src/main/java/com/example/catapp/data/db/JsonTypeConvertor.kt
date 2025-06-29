package com.example.catapp.data.db

import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

@Suppress("unused")
class JsonTypeConvertor {

    private companion object {
        private val Json = Json {
            ignoreUnknownKeys = true
            prettyPrint = false
        }
    }

    @TypeConverter
    fun jsonObjectToString(jsonObject: JsonObject?): String? {
        return when (jsonObject) {
            null -> null
            else -> Json.encodeToString(JsonObject.serializer(), jsonObject)
        }
    }

    @TypeConverter
    fun stringToJsonObject(value: String?): JsonObject? {
        return value?.let { Json.decodeFromString(it) }
    }

}