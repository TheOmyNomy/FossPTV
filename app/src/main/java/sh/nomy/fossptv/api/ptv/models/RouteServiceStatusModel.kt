package sh.nomy.fossptv.api.ptv.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RouteServiceStatusModel(
    @Json(name = "description") val description: String,
    @Json(name = "timestamp") val timestamp: String
)