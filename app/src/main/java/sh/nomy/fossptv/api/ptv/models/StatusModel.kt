package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class StatusModel(
    @JsonProperty("version") val version: String? = null,
    @JsonProperty("health") val health: Int? = null
)