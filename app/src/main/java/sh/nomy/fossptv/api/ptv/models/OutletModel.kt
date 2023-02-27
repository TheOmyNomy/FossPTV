package sh.nomy.fossptv.api.ptv.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OutletModel(
    @Json(name = "outlet_distance") val outletDistance: Int,
    @Json(name = "outlet_slid_spid") val outletSlidSpid: String,
    @Json(name = "outlet_name") val outletName: String,
    @Json(name = "outlet_business") val outletBusiness: String,
    @Json(name = "outlet_latitude") val outletLatitude: Float,
    @Json(name = "outlet_longitude") val outletLongitude: Float,
    @Json(name = "outlet_suburb") val outletSuburb: String,
    @Json(name = "outlet_postcode") val outletPostcode: Int,
    @Json(name = "outlet_business_hour_mon") val outletBusinessHourMon: String,
    @Json(name = "outlet_business_hour_tue") val outletBusinessHourTue: String,
    @Json(name = "outlet_business_hour_wed") val outletBusinessHourWed: String,
    @Json(name = "outlet_business_hour_thur") val outletBusinessHourThur: String,
    @Json(name = "outlet_business_hour_fri") val outletBusinessHourFri: String,
    @Json(name = "outlet_business_hour_sat") val outletBusinessHourSat: String,
    @Json(name = "outlet_business_hour_sun") val outletBusinessHourSun: String,
    @Json(name = "outlet_notes") val outletNotes: String
)