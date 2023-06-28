package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class StopModel(
    @JsonProperty("stop_distance") val stopDistance: Int? = null,
    @JsonProperty("stop_suburb") val stopSuburb: String? = null,
    @JsonProperty("route_type") val routeType: Int? = null,
    @JsonProperty("routes") val routes: List<RouteModel>? = null,
    @JsonProperty("stop_latitude") val stopLatitude: Float? = null,
    @JsonProperty("stop_longitude") val stopLongitude: Float? = null,
    @JsonProperty("stop_sequence") val stopSequence: Int? = null,
    @JsonProperty("stop_id") val stopId: Int? = null,
    @JsonProperty("stop_name") val stopName: String? = null,
    @JsonProperty("stop_landmark") val stopLandmark: String? = null
)