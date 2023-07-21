package sh.nomy.fossptv.api.ptv.models

import com.fasterxml.jackson.annotation.JsonProperty

data class RunsResponse(
    @JsonProperty("runs") val runs: List<Run>? = null
) : Response()