package free.ssharyk.themoviedatabaseclient.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PaginatedMoviesResponse(
    val page: Int,
    val results: List<MovieResponse>,
    @Json(name = "total_results") val count: Int,
    @Json(name = "total_pages") val pages: Int,
)