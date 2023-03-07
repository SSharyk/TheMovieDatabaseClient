package free.ssharyk.themoviedatabaseclient.features.popular.service

import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.RemotePopularMoviesDataSource
import free.ssharyk.themoviedatabaseclient.network.http.BaseHttpService
import free.ssharyk.themoviedatabaseclient.network.models.MovieResponse
import free.ssharyk.themoviedatabaseclient.network.models.PaginatedMoviesResponse

class MoviesLoaderService : BaseHttpService<TheMovieDatabaseApi>(),
    RemotePopularMoviesDataSource {

    override val klazz: Class<TheMovieDatabaseApi> = TheMovieDatabaseApi::class.java

    override suspend fun loadPopular(): List<Movie> =
        makeRequest<PaginatedMoviesResponse> {
            getPopularMovies()
        }.getOrNull()?.results?.map { it.toDomain() } ?: emptyList()

}