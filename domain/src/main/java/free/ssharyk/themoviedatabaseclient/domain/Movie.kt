package free.ssharyk.themoviedatabaseclient.domain

/**
 * Видеоконтент (основная сущность)
 */
data class Movie(
    val id: String,
    val type: MovieType,
    val title: String,
    val description: String,
    val releaseYear: Int,
    val posterUrl: String,
)