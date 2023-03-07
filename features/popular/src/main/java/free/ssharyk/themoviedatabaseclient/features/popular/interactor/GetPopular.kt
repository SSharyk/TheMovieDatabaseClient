package free.ssharyk.themoviedatabaseclient.features.popular.interactor

import free.ssharyk.themoviedatabaseclient.domain.Movie
import kotlinx.coroutines.flow.Flow

/**
 * Загрузка популярных фильмов и сериалов
 */
interface GetPopular {

    /**
     * @return реактивный список популярных фильмов и сериалов
     */
    fun loadPopular(): Flow<List<Movie>>
}