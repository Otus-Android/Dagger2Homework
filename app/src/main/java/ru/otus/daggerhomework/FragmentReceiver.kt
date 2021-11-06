package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentReceiver : Fragment() {
    
    @Inject
    lateinit var viewModelFactory: ViewModelReceiverFactory
    private val viewModel: ViewModelReceiver by viewModels { viewModelFactory }
    private var frame: View? = null
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val dependenciesProvider = activity as? DependenciesProvider<FragmentReceiverDependencies>
            ?: throw ClassCastException(
                "Activity must implement `DependenciesProvider` of `FragmentReceiverDependencies`"
            )
        DaggerFragmentReceiverComponent.builder()
            .fragmentReceiverDependencies(dependenciesProvider.getDependencies())
            .build()
            .inject(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        observeColors()
    }
    
    private fun observeColors() = with(viewLifecycleOwner) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.colors.collect { state ->
                    populateColor(state.color)
                }
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        frame = null
    }

    private fun populateColor(@ColorInt color: Int) {
        frame?.setBackgroundColor(color)
    }
}