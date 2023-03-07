package free.ssharyk.themoviedatabaseclient.features.popular

import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.domain.MovieType
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.RemotePopularMoviesDataSource

class FakeNetworkLoader: RemotePopularMoviesDataSource {

    companion object {
        val DEFAULT_MOVIES = listOf(
            Movie("11", MovieType.FILM, "Movie1", "descr1", 2000, ""),
            Movie("222", MovieType.SERIES, "Series2", "descr2", 2022, "http://google.com/favicon")
        )
    }

    var movies: List<Movie> = ArrayList(DEFAULT_MOVIES)

    override suspend fun loadPopular(): List<Movie> = movies

}