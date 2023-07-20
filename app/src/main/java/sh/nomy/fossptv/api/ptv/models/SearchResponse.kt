package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchResponse(
    @JsonProperty("stops") val stops: List<Stop>? = null,
    @JsonProperty("routes") val routes: List<Route>? = null,
    @JsonProperty("outlets") val outlets: List<Outlet>? = null
) : Response()