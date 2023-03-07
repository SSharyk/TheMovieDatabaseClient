package free.ssharyk.themoviedatabaseclient.features.base


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified V : ViewBinding> fragmentBinding() = FragmentBindingDelegate(V::class.java, null)
inline fun <reified V : ViewBinding> fragmentBinding(noinline init: () -> V) = FragmentBindingDelegate(V::class.java, init)


@Suppress("UNCHECKED_CAST")
class FragmentBindingDelegate<T : ViewBinding>(
    private val bindingClass: Class<T>,
    private val initBlock: (() -> T?)?
) : ReadOnlyProperty<BaseFragment<T, *>, T> {

    private var binding: T? = null

    override fun getValue(thisRef: BaseFragment<T, *>, property: KProperty<*>): T {
        val preInit = initBlock?.invoke()
        if (preInit != null) return preInit
        binding?.let { return it }

        initLifecycleListeners(thisRef)
        val inflateMethod = bindingClass.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )

        return binding ?: synchronized(this) {
            binding ?: (inflateMethod.invoke(
                null,
                thisRef.layoutInflater,
                thisRef.container,
                false
            ) as T).also {
                binding = it
            }
        }
    }

    private fun initLifecycleListeners(fragment: Fragment) {
        fragment.lifecycle.addObserver(object : LifecycleEventObserver {

            private val viewLifecycleObserver = Observer<LifecycleOwner?> {
                val viewLifecycleOwner = it ?: return@Observer
                viewLifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
                    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            binding = null
                        }
                    }
                })
            }

            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when(event) {
                    Lifecycle.Event.ON_CREATE -> {
                        fragment.viewLifecycleOwnerLiveData.observeForever(viewLifecycleObserver)
                    }
                    Lifecycle.Event.ON_DESTROY -> {
                        fragment.viewLifecycleOwnerLiveData.removeObserver(viewLifecycleObserver)
                    }
                    else -> {
                    }
                }
            }
        })
    }

}