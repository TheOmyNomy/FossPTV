package sh.nomy.fossptv.api.ptv

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import sh.nomy.fossptv.api.ptv.models.SearchModel
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object PtvClient {
    private const val developerId = -1
    private const val developerKey = ""

    private const val baseUrl = "https://timetableapi.ptv.vic.gov.au"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun search(term: String): SearchModel? {
        val response = fetch("/v3/search/$term") ?: return null

        val adapter: JsonAdapter<SearchModel> = moshi.adapter(SearchModel::class.java)
        val result: SearchModel?

        try {
            result = adapter.fromJson(response)
        } catch (e: JsonDataException) {
            e.printStackTrace()
            return null
        }

        return result
    }

    private fun constructRequestUrl(url: String): String {
        val algorithm = "HMACSHA1"

        val keyBytes = developerKey.toByteArray()

        val signatureUrl = url + if (url.contains("?")) "&" else "?devid=$developerId"
        val signatureUrlBytes = signatureUrl.toByteArray()

        val signingKey = SecretKeySpec(keyBytes, algorithm)

        val mac = Mac.getInstance(algorithm)
        mac.init(signingKey)

        val signatureBytes = mac.doFinal(signatureUrlBytes)
        val signature = StringBuffer(signatureBytes.size * 2)

        for (signatureByte in signatureBytes) {
            val value = signatureByte.toInt() and 0xff

            if (value < 0x10) {
                signature.append('0')
            }

            signature.append(Integer.toHexString(value))
        }

        return baseUrl + url + if (url.contains("?")) "&" else "?devid=$developerId&signature=$signature"
    }

    private fun fetch(url: String): String? {
        val requestUrl = constructRequestUrl(url)
        val request = Request.Builder().url(requestUrl).build()

        try {
            OkHttpClient().newCall(request).execute().use { response ->
                return response.body!!.string()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }
}