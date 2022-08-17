package ru.otus.daggerhomework.screens.receiver

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.observer.ColorState
import ru.otus.daggerhomework.screens.main.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.ViewModelFactory
import ru.otus.daggerhomework.injectViewModel
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: ViewModelReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityComponent = (requireActivity() as MainActivity).getActivityComponent()
        val fragmentReceiverComponent =
            DaggerFragmentReceiverComponent.factory().create(activityComponent)
        fragmentReceiverComponent.inject(this)

        viewModel = injectViewModel(viewModelFactory)
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

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeColors()
                    .collect { state ->
                    when (state) {
                        is ColorState.Color -> state.color
                        ColorState.Default -> Color.WHITE
                    }.also { color ->
                        populateColor(color)
                    }
                }
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}