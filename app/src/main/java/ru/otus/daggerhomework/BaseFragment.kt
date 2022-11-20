package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment : Fragment {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDetach() {
        super.onDetach()
    }
}

abstract class ViewBindingFragment<V : ViewBinding> : BaseFragment {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    protected var binding: V? = null

    override fun onDestroyView() {
        super.onDestroyView()
        view?.post {
            Log.d(this.javaClass.name, "binding release ${binding?.let { it::class.simpleName }}");
            binding = null
        }
    }
}

abstract class ViewModelFragment<V : ViewBinding> : ViewBindingFragment<V> {

    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected inline fun <reified VM : ViewModel> activityViewModel(): Lazy<VM> =
        activityViewModels { viewModelFactory }

    protected inline fun <reified VM : ViewModel> viewModel(): Lazy<VM> =
        viewModels { viewModelFactory }
}