package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchModel(
    @JsonProperty("stops") val stops: List<StopModel>? = null,
    @JsonProperty("routes") val routes: List<RouteModel>? = null,
    @JsonProperty("outlets") val outlets: List<OutletModel>? = null,
    @JsonProperty("status") val status: StatusModel? = null
)