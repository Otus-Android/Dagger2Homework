package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.DaggerReceiverFragmentComponent
import ru.otus.daggerhomework.di.ReceiverFragmentComponent
import javax.inject.Inject

class ReceiverFragment : Fragment(R.layout.fragment_receiver) {


    @Inject
    lateinit var viewModelFactory: ReceiverViewModel.Factory

    private lateinit var viewModel: ReceiverViewModel

    private lateinit var fragmentReceiverComponent: ReceiverFragmentComponent

    private lateinit var frame: View

    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentReceiverComponent = DaggerReceiverFragmentComponent
            .factory()
            .create((requireActivity() as MainActivity).activityComponent)

        fragmentReceiverComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[ReceiverViewModel::class.java]
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