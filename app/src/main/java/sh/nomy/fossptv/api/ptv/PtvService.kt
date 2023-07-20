package sh.nomy.fossptv.api.ptv

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sh.nomy.fossptv.api.ptv.models.RouteTypesResponse
import sh.nomy.fossptv.api.ptv.models.SearchResponse

interface PtvService {
    @GET("route_types")
    fun getRouteTypes(): Call<RouteTypesResponse>

    @GET("search/{term}")
    fun getSearch(
        @Path("term") term: String,
        @Query("route_types") routeTypes: List<Int>? = null,
        @Query("latitude") latitude: Float? = null,
        @Query("longitude") longitude: Float? = null,
        @Query("max_distance") maxDistance: Float? = null,
        @Query("include_outlets") includeOutlets: Boolean? = null,
        @Query("match_stop_by_suburb") matchStopBySuburb: Boolean? = null,
        @Query("match_route_by_suburb") matchRouteBySuburb: Boolean? = null,
        @Query("match_stop_by_gtfs_stop_id") matchStopByGtfsStopId: Boolean? = null
    ): Call<SearchResponse>
}