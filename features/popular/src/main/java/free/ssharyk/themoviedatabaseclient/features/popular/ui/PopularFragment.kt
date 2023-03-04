package free.ssharyk.themoviedatabaseclient.features.popular.ui

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import free.ssharyk.themoviedatabaseclient.features.base.BaseFragment
import free.ssharyk.themoviedatabaseclient.features.popular.databinding.FragmentPopularBinding
class PopularFragment : BaseFragment<FragmentPopularBinding, PopularViewModel>() {

    override val binding by viewBinding(FragmentPopularBinding::bind)
    override val viewModel: PopularViewModel by viewModels()

}