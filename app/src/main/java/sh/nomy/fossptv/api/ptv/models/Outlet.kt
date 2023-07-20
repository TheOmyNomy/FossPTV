package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Outlet(
    @JsonProperty("outlet_distance") val outletDistance: Int? = null,
    @JsonProperty("outlet_slid_spid") val outletSlidSpid: String? = null,
    @JsonProperty("outlet_name") val outletName: String? = null,
    @JsonProperty("outlet_business") val outletBusiness: String? = null,
    @JsonProperty("outlet_latitude") val outletLatitude: Float? = null,
    @JsonProperty("outlet_longitude") val outletLongitude: Float? = null,
    @JsonProperty("outlet_suburb") val outletSuburb: String? = null,
    @JsonProperty("outlet_postcode") val outletPostcode: Int? = null,
    @JsonProperty("outlet_business_hour_mon") val outletBusinessHourMon: String? = null,
    @JsonProperty("outlet_business_hour_tue") val outletBusinessHourTue: String? = null,
    @JsonProperty("outlet_business_hour_wed") val outletBusinessHourWed: String? = null,
    @JsonProperty("outlet_business_hour_thur") val outletBusinessHourThur: String? = null,
    @JsonProperty("outlet_business_hour_fri") val outletBusinessHourFri: String? = null,
    @JsonProperty("outlet_business_hour_sat") val outletBusinessHourSat: String? = null,
    @JsonProperty("outlet_business_hour_sun") val outletBusinessHourSun: String? = null,
    @JsonProperty("outlet_notes") val outletNotes: String? = null
)