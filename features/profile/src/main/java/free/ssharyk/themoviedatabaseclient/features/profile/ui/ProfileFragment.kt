package free.ssharyk.themoviedatabaseclient.features.profile.ui

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import free.ssharyk.themoviedatabaseclient.features.profile.databinding.FragmentProfileBinding
import free.ssharyk.themoviedatabaseclient.features.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override val binding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel: ProfileViewModel by viewModels()

}