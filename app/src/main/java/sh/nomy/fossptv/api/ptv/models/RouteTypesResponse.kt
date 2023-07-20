package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class RouteTypesResponse(
    @JsonProperty("route_types") val routeTypes: List<RouteType>? = null,
) : Response()