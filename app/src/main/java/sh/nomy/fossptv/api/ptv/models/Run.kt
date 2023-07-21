package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Run(
    @JsonProperty("run_id") val id: Int? = null,
    @JsonProperty("run_ref") val ref: String? = null,
    @JsonProperty("route_id") val routeId: Int? = null,
    @JsonProperty("route_type") val routeType: Int? = null,
    @JsonProperty("final_stop_id") val finalStopId: Int? = null,
    @JsonProperty("destination_name") val destinationName: String? = null,
    @JsonProperty("status") val status: String? = null,
    @JsonProperty("direction_id") val directionId: Int? = null,
    @JsonProperty("run_sequence") val Sequence: Int? = null,
    @JsonProperty("express_stop_count") val ExpressStopCount: Int? = null,
    @JsonProperty("vehicle_position") val VehiclePosition: VehiclePosition? = null,
    @JsonProperty("vehicle_descriptor") val VehicleDescriptor: VehicleDescriptor? = null,
    @JsonProperty("geopath") val Geopath: List<Any>? = null
)