package free.ssharyk.themoviedatabaseclient.features.popular.interactor

import free.ssharyk.themoviedatabaseclient.domain.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularUseCaseImpl @Inject constructor(
    private val remoteDataSource: RemotePopularMoviesDataSource,
): GetPopular {

    override fun loadPopular(): Flow<List<Movie>> = flow {
        emit(remoteDataSource.loadPopular())
    }

}