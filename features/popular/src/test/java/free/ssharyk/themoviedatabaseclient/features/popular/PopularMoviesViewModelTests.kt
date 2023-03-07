package free.ssharyk.themoviedatabaseclient.features.popular

import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.GetPopularUseCaseImpl
import free.ssharyk.themoviedatabaseclient.features.popular.ui.PopularViewModel
import free.ssharyk.themoviedatabaseclient.testing.MainDispatcherRule
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class PopularMoviesViewModelTests {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val networkLoader = FakeNetworkLoader()

    private fun setup(movies: List<Movie> = emptyList()): PopularViewModel {
        networkLoader.movies = ArrayList(movies)
        return PopularViewModel(
            GetPopularUseCaseImpl(networkLoader)
        )
    }

    @Test
    fun uiState_whenLoadedWithErrors_thenShowEmpty() = runTest {
        val viewModel = setup()
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.popularMovies.collect() }
        assertEquals(PopularViewModel.UiState.Empty, viewModel.popularMovies.value)
        collectJob.cancel()
    }

    @Test
    fun uiState_whenLoadedWithSuccess_thenShowList() = runTest {
        val viewModel = setup(FakeNetworkLoader.DEFAULT_MOVIES)
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.popularMovies.collect() }
        assertEquals(
            PopularViewModel.UiState.MoviesList(FakeNetworkLoader.DEFAULT_MOVIES),
            viewModel.popularMovies.value
        )
        collectJob.cancel()
    }

}