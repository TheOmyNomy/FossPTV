package sh.nomy.fossptv.api.ptv.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatusModel(
    @Json(name = "version") val version: String,
    @Json(name = "health") val health: Int
)