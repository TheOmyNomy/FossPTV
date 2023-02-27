package sh.nomy.fossptv.api.ptv.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchModel(
    @Json(name = "stops") val stops: List<StopModel>,
    @Json(name = "routes") val routes: List<RouteModel>,
    @Json(name = "outlets") val outlets: List<OutletModel>,
    @Json(name = "status") val status: StatusModel
)