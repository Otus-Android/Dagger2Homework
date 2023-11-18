package ru.otus.daggerhomework.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.fragments.FragmentProducerComponent
import ru.otus.daggerhomework.presentation.viewmodels.SentColor
import ru.otus.daggerhomework.presentation.viewmodels.ProducerViewModel
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModel: ProducerViewModel

    @Inject
    lateinit var sentColor: SentColor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_a, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentProducerComponent
            .getFragmentProducerComponent((requireActivity() as MainActivity).component)
            .inject(this)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            sentColor.sent(viewModel.generateColor())
        }
    }
}