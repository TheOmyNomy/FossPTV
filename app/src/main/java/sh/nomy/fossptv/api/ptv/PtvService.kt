package sh.nomy.fossptv.api.ptv

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import sh.nomy.fossptv.api.ptv.models.RouteTypesResponse
import sh.nomy.fossptv.api.ptv.models.SearchResponse

interface PtvService {
    @GET("route_types")
    fun getRouteTypes(): Call<RouteTypesResponse>

    @GET("search/{term}")
    fun getSearch(@Path("term") term: String): Call<SearchResponse>
}