package ru.otus.daggerhomework.receiver

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.ViewBindingFragment
import ru.otus.daggerhomework.databinding.FragmentBBinding
import ru.otus.daggerhomework.main.MainActivity
import javax.inject.Inject

class FragmentReceiver : ViewBindingFragment<FragmentBBinding>(R.layout.fragment_b) {

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFragmentReceiverComponent.factory().create(
            (activity as MainActivity).activityComponent
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentBBinding.bind(view)

        lifecycleScope.launch {
            viewModelReceiver.observeColors()
        }
        lifecycleScope.launch {
            viewModelReceiver.colorFlow.collect { color ->
                if (color != null) {
                    populateColor(color)
                }
            }
        }
    }

    fun populateColor(@ColorInt color: Int) = binding?.run {
        frame.setBackgroundColor(color)
    }
}