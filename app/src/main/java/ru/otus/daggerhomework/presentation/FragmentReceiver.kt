package ru.otus.daggerhomework.presentation

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
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.fragments.FragmentReceiverComponent
import ru.otus.daggerhomework.presentation.viewmodels.ReceiveColorFlow
import ru.otus.daggerhomework.presentation.viewmodels.ReceiveColorFlow.Companion.INIT_VALUE
import ru.otus.daggerhomework.presentation.viewmodels.ReceiverViewModel
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModel: ReceiverViewModel

    @Inject
    lateinit var receiveColor: ReceiveColorFlow
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentReceiverComponent
            .getFragmentReceiverComponent((requireActivity() as MainActivity).component)
            .inject(this)
        frame = view.findViewById(R.id.frame)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                receiveColor.flow.collect {
                    if (it != INIT_VALUE) {
                        viewModel.observeColors()
                        populateColor(it)
                    }
                }
            }
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}