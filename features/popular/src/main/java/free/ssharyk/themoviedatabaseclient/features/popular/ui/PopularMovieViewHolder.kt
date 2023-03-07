package free.ssharyk.themoviedatabaseclient.features.popular.ui

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import free.ssharyk.themoviedatabaseclient.features.popular.R
import free.ssharyk.themoviedatabaseclient.features.popular.databinding.VhPopularBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class PopularMovieViewHolder @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val binding = VhPopularBinding.inflate(
        LayoutInflater.from(context), this
    )

    @TextProp
    fun title(text: CharSequence?) {
        binding.movieTitle.text = text
    }

    @ModelProp
    fun poster(uri: Uri?) {
        if (uri == null) {
            binding.moviePoster.setImageResource(R.drawable.ic_no_poster)
        } else {
            binding.moviePoster.load(uri)
        }
    }
}