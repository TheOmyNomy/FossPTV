package sh.nomy.fossptv.api.ptv

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sh.nomy.fossptv.api.ptv.models.RouteTypesResponse
import sh.nomy.fossptv.api.ptv.models.RunResponse
import sh.nomy.fossptv.api.ptv.models.RunsResponse
import sh.nomy.fossptv.api.ptv.models.SearchResponse
import java.util.Date

interface PtvService {
    @GET("route_types")
    fun getRouteTypes(): Call<RouteTypesResponse>

    @GET("runs/route/{route_id}")
    fun getRuns(
        @Path("route_id") routeId: Int,
        @Query("expand") expand: List<String>? = null,
        @Query("date_utc") dateUtc: Date? = null
    ): Call<RunsResponse>

    @GET("runs/route/{route_id}/route_type/{route_type}")
    fun getRuns(
        @Path("route_id") routeId: Int,
        @Path("route_type") routeType: Int,
        @Query("expand") expand: List<String>? = null,
        @Query("date_utc") dateUtc: Date? = null
    ): Call<RunsResponse>

    @GET("runs/{run_ref}")
    fun getRuns(
        @Path("run_ref") runRef: String,
        @Query("expand") expand: List<String>? = null,
        @Query("date_utc") dateUtc: Date? = null
    ): Call<RunsResponse>

    @GET("runs/{run_ref}/route_type/{route_type}")
    fun getRun(
        @Path("run_ref") runRef: String,
        @Path("route_type") routeType: Int,
        @Query("expand") expand: List<String>? = null,
        @Query("date_utc") dateUtc: Date? = null
    ): Call<RunResponse>

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