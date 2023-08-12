package ru.otus.daggerhomework.feature.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.App
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.activity.MainActivity
import ru.otus.daggerhomework.feature.di.ReceiverFragmentComponent
import ru.otus.daggerhomework.feature.viewmodels.ReceiverViewModel
import javax.inject.Inject

class ReceiverFragment : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModel: ReceiverViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ReceiverFragmentComponent.create(
            requireActivity().application as App,
            requireActivity() as MainActivity
        ).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        setupObservers()
    }

    private fun setupObservers() =
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateColor.filterNotNull().collect {
                    populateColor(it)
                }
            }
        }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
        viewModel.onColorPopulate()
    }
}