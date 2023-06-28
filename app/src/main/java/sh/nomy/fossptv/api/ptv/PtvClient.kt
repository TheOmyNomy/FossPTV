package sh.nomy.fossptv.api.ptv

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object PtvClient {
    private lateinit var baseUrl: String
    private lateinit var retrofitInstance: Retrofit
    lateinit var instance: PtvService

    fun updateBaseUrl(url: String) {
        baseUrl = url

        retrofitInstance = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        instance = retrofitInstance.create(PtvService::class.java)
    }
}