package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class RunResponse(
    @JsonProperty("run") val run: Run? = null
) : Response()