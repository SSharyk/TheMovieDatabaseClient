package free.ssharyk.themoviedatabaseclient.features.popular.service

import org.json.JSONObject
import retrofit2.http.GET

interface TheMovieDatabaseApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): JSONObject

}