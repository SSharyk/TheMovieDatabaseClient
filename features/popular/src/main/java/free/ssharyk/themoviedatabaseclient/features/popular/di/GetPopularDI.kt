package free.ssharyk.themoviedatabaseclient.features.popular.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.GetPopular
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.GetPopularUseCaseImpl
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.RemotePopularMoviesDataSource
import free.ssharyk.themoviedatabaseclient.features.popular.service.MoviesLoaderService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GetPopularDI {

    @Provides
    @Singleton
    fun provideService(): RemotePopularMoviesDataSource = MoviesLoaderService()

    @Provides
    @Singleton
    fun provideGetPopular(
        remoteDataSource: RemotePopularMoviesDataSource,
    ): GetPopular = GetPopularUseCaseImpl(remoteDataSource)

}