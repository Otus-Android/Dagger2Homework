package ru.otus.daggerhomework.producer

import android.content.Context
import android.os.Bundle
import android.view.View
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.ViewModelFragment
import ru.otus.daggerhomework.databinding.FragmentABinding
import ru.otus.daggerhomework.receiver.FragmentReceiver
import ru.otus.daggerhomework.setFragment

class FragmentProducer : ViewModelFragment<FragmentABinding>(R.layout.fragment_a) {

    companion object {
        fun newInstance() = FragmentProducer()
    }

    private val viewModel: ViewModelProducer by viewModel()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent.factory().create(
            (activity as MainActivity).activityComponent
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentABinding.bind(view).apply {
            button.setOnClickListener {
                viewModel.generateColor()
                setFragment(FragmentReceiver.newInstance())
            }
        }
    }
}