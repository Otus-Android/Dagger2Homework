package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.component.ReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {
    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    private lateinit var frame: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        viewModelReceiver.observeColors()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModelReceiver.colorFlow.collect { color ->
                color?.let {
                    populateColor(it)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReceiverComponent.getReceiverComponent((requireActivity() as MainActivity).getMainActivityComponent())
            .inject(this)
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}