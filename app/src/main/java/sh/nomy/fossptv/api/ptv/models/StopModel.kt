package sh.nomy.fossptv.api.ptv.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StopModel(
    @Json(name = "stop_distance") val stopDistance: Int,
    @Json(name = "stop_suburb") val stopSuburb: String,
    @Json(name = "route_type") val routeType: Int,
    @Json(name = "routes") val routes: List<RouteModel>,
    @Json(name = "stop_latitude") val stopLatitude: Float,
    @Json(name = "stop_longitude") val stopLongitude: Float,
    @Json(name = "stop_sequence") val stopSequence: Int,
    @Json(name = "stop_id") val stopId: Int,
    @Json(name = "stop_name") val stopName: String,
    @Json(name = "stop_landmark") val stopLandmark: String
)