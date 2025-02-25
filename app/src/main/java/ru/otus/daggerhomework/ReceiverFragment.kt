package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.DaggerReceiverFragmentComponent
import ru.otus.daggerhomework.di.ReceiverFragmentComponent
import javax.inject.Inject

class ReceiverFragment : Fragment() {

    private lateinit var frame: View

    @Inject
    lateinit var viewModel: ReceiverViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerReceiverFragmentComponent.factory()
            .create((requireActivity() as MainActivity).getActivityComponent())
            .inject(this)
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
        lifecycleScope.launch {
            viewModel.observeColors().collect { value ->
                populateColor(value)
            }
        }

    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}