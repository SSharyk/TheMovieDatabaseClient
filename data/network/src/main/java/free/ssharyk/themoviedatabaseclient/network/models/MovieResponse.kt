package free.ssharyk.themoviedatabaseclient.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.domain.MovieType

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val id: Int = 0,
    val title: String = "",
    val overview: String = "",
    @Json(name = "poster_path") val poster: String? = "",
    @Json(name = "release_date") val releaseDate: String = "",
) {

    fun toDomain(): Movie {
        return Movie(
            id = id.toString(),
            type = MovieType.FILM,
            title = title,
            description = overview,
            releaseYear = 11, //  dateOf(releaseDate).year,
            posterUrl = poster ?: ""
        )
    }
}