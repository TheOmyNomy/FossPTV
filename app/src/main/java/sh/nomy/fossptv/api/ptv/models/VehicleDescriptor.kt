package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class VehicleDescriptor(
    @JsonProperty("operator") val operator: String? = null,
    @JsonProperty("id") val id: String? = null,
    @JsonProperty("low_floor") val lowFloor: Boolean? = null,
    @JsonProperty("air_conditioned") val airConditioned: Boolean? = null,
    @JsonProperty("description") val description: String? = null,
    @JsonProperty("supplier") val supplier: String? = null,
    @JsonProperty("length") val length: String? = null
)