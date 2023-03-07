package free.ssharyk.themoviedatabaseclient.features.popular.interactor

import free.ssharyk.themoviedatabaseclient.domain.Movie


/**
 * Загрузка данных с сервера
 */
interface RemotePopularMoviesDataSource {

    /**
     * Получение списка популярных фильмов и сериалов.
     *
     * Не будем добавлять еще один уровень абстракции и DTO и попросим того,
     * кто реализует загрузку, предоставить уже объекты предметной области.
     */
    suspend fun loadPopular(): List<Movie>

}