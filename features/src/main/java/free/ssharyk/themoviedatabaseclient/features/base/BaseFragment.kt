package free.ssharyk.themoviedatabaseclient.features.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM: BaseViewModel> : Fragment() {

    protected abstract val binding: VB

    protected abstract val viewModel: VM
}