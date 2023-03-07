package free.ssharyk.themoviedatabaseclient.features.popular.ui

import android.net.Uri
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.features.base.BaseFragment
import free.ssharyk.themoviedatabaseclient.features.base.fragmentBinding
import free.ssharyk.themoviedatabaseclient.features.popular.R
import free.ssharyk.themoviedatabaseclient.features.popular.databinding.FragmentPopularBinding
import free.ssharyk.themoviedatabaseclient.features.popular.ui.PopularPresentingConfig.GRID_COLUMNS
import free.ssharyk.themoviedatabaseclient.network.ApiConstant

@AndroidEntryPoint
class PopularFragment : BaseFragment<FragmentPopularBinding, PopularViewModel>() {

    override val binding: FragmentPopularBinding by fragmentBinding()
    override val viewModel: PopularViewModel by viewModels()

    override fun configure() {
        collectFlow {
            viewModel.popularMovies.collect { allMoviesUiState ->
                when (allMoviesUiState) {
                    PopularViewModel.UiState.Empty -> renderPlaceholder(R.string.popular_not_found)
                    PopularViewModel.UiState.Loading -> renderPlaceholder(R.string.popular_loading_error)
                    is PopularViewModel.UiState.MoviesList -> renderMovies(allMoviesUiState.movies)
                }
            }
        }
    }

    private fun renderPlaceholder(@StringRes message: Int) {
        binding.ervPopular.visibility = View.GONE
        with(binding.placeholder) {
            visibility = View.VISIBLE
            setText(message)
        }
    }

    private fun renderMovies(allMovies: List<Movie>) {
        binding.placeholder.visibility = View.GONE
        binding.ervPopular.visibility = View.VISIBLE

        val ltManager = GridLayoutManager(context, GRID_COLUMNS)
        binding.ervPopular.layoutManager = ltManager
        binding.ervPopular.withModels {
            this.spanCount = spanCount
            ltManager.spanSizeLookup = this.spanSizeLookup
            allMovies.take(PopularPresentingConfig.TOTAL_ITEMS).forEach { movie ->
                popularMovieViewHolder {
                    id("movie-${movie.id}")
                    spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount / GRID_COLUMNS }
                    title(movie.title)

                    if (movie.posterUrl.isEmpty()) {
                        poster(null)
                    } else {
                        poster(Uri.parse(ApiConstant.IMAGES_STORAGE_URL + movie.posterUrl))
                    }
                }
            }
        }
    }
}