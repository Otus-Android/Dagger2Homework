package ru.otus.daggerhomework.receiver

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.ViewModelFragment
import ru.otus.daggerhomework.databinding.FragmentBBinding

class FragmentReceiver : ViewModelFragment<FragmentBBinding>(R.layout.fragment_b) {

    companion object {
        fun newInstance() = FragmentReceiver()
    }

    val viewModel: ViewModelReceiver by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentReceiverComponent.factory().create(
            (activity as MainActivity).activityComponent).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBBinding.bind(view)
        viewModel.receiver.observe(viewLifecycleOwner, ::populateColor)
    }

    fun populateColor(@ColorInt color: Int) = binding?.run {
        frame.setBackgroundColor(color)
    }
}