package free.ssharyk.themoviedatabaseclient.features.popular.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.features.base.BaseViewModel
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.GetPopular
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    getPopular: GetPopular,
) : BaseViewModel() {


    sealed class UiState {
        object Loading : UiState()
        object Empty : UiState()
        data class MoviesList(val movies: List<Movie>) : UiState()
    }


    private val uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val popularMovies: StateFlow<UiState> = uiState

    init {
        viewModelScope.launch {
            getPopular.loadPopular().collect { movies ->
                uiState.value = if (movies.isEmpty()) {
                    UiState.Empty
                } else {
                    UiState.MoviesList(movies)
                }
            }
        }
    }

}