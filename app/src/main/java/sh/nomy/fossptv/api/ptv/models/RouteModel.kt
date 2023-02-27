package sh.nomy.fossptv.api.ptv.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RouteModel(
    @Json(name = "route_name") val routeName: String,
    @Json(name = "route_number") val routeNumber: String,
    @Json(name = "route_type") val routeType: Int,
    @Json(name = "route_id") val routeId: Int,
    @Json(name = "route_gtfs_id") val routeGtfsId: String,
    @Json(name = "route_service_status") val routeServiceStatus: RouteServiceStatusModel
)