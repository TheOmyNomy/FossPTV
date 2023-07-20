package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Route(
    @JsonProperty("route_name") val routeName: String? = null,
    @JsonProperty("route_number") val routeNumber: String? = null,
    @JsonProperty("route_type") val routeType: Int? = null,
    @JsonProperty("route_id") val routeId: Int? = null,
    @JsonProperty("route_gtfs_id") val routeGtfsId: String? = null,
    @JsonProperty("route_service_status") val routeServiceStatus: RouteServiceStatus? = null,
    @JsonProperty("geopath") val geopath: List<Any>? = null
)