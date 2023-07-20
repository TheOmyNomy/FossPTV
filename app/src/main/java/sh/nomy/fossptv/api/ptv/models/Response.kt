package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

open class Response {
    @JsonProperty("message")
    val message: String? = null

    @JsonProperty("status")
    val status: Status? = null
}