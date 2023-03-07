package free.ssharyk.themoviedatabaseclient.features.profile.ui

import androidx.fragment.app.viewModels
import free.ssharyk.themoviedatabaseclient.features.profile.databinding.FragmentProfileBinding
import free.ssharyk.themoviedatabaseclient.features.base.BaseFragment
import free.ssharyk.themoviedatabaseclient.features.base.fragmentBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override val binding by fragmentBinding<FragmentProfileBinding>()
    override val viewModel: ProfileViewModel by viewModels()

    override fun configure() {
    }
}