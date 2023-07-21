package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class VehiclePosition(
    @JsonProperty("latitude") val latitude: Float? = null,
    @JsonProperty("longitude") val longitude: Float? = null,
    @JsonProperty("easting") val easting: Float? = null,
    @JsonProperty("northing") val northing: Float? = null,
    @JsonProperty("direction") val direction: String? = null,
    @JsonProperty("bearing") val bearing: Float? = null,
    @JsonProperty("supplier") val supplier: String? = null,
    @JsonProperty("datetime_utc") val dateTimeUtc: String? = null,
    @JsonProperty("expiery_time") val expiryTime: String? = null
)