package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class RouteType(
    @JsonProperty("route_type_name") val name: String? = null,
    @JsonProperty("route_type") val id: Int? = null
)