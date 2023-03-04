package free.ssharyk.themoviedatabaseclient.features.search.ui

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import free.ssharyk.themoviedatabaseclient.features.base.BaseFragment
import free.ssharyk.themoviedatabaseclient.features.search.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val binding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel: SearchViewModel by viewModels()

}