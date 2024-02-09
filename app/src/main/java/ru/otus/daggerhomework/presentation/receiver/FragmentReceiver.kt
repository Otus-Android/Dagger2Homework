package ru.otus.daggerhomework.presentation.receiver

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import ru.otus.daggerhomework.presentation.activity.MainActivity
import ru.otus.daggerhomework.util.assistedViewModel
import java.lang.ref.WeakReference

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    lateinit var component: FragmentReceiverComponent

    val viewModel: ViewModelReceiver by assistedViewModel { savedStateHandle ->
        component.viewModelFactory.create(savedStateHandle, component.appContext)
    }

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component = FragmentReceiverComponent.factory().create(
            (requireActivity() as MainActivity).mainActivityComponent
        )
        viewModel.updateContext(component.appContext)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewModel.colorFlow.
            flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { populateColor(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeColors(component.appContext)
            }
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
