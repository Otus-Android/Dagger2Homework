package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.di.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    @Inject
    lateinit var viewModelFactory: ViewModelReceiver.Factory

    private lateinit var viewModel: ViewModelReceiver

    private lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentReceiverComponent = DaggerFragmentReceiverComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)

        fragmentReceiverComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ViewModelReceiver::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewModel.colorFlow
            .flowWithLifecycle(lifecycle, Lifecycle.State.RESUMED)
            .onEach {
                it?.let(::populateColor)
            }
            .launchIn(lifecycleScope)

        viewModel.observeColors()
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}