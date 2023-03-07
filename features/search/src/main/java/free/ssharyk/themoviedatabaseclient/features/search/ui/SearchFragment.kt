package free.ssharyk.themoviedatabaseclient.features.search.ui

import androidx.fragment.app.viewModels
import free.ssharyk.themoviedatabaseclient.features.base.BaseFragment
import free.ssharyk.themoviedatabaseclient.features.base.fragmentBinding
import free.ssharyk.themoviedatabaseclient.features.search.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val binding by fragmentBinding<FragmentSearchBinding>()
    override val viewModel: SearchViewModel by viewModels()

    override fun configure() {
    }

}