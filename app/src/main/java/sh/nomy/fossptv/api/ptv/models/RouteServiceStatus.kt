package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class RouteServiceStatus(
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("timestamp") val timestamp: String? = null
)