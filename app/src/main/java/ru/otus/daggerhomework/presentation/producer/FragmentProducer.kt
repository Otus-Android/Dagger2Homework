package ru.otus.daggerhomework.presentation.producer

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.FragmentProducerComponent
import ru.otus.daggerhomework.presentation.activity.MainActivity
import ru.otus.daggerhomework.util.assistedViewModel

class FragmentProducer : Fragment(R.layout.fragment_a) {

    lateinit var component: FragmentProducerComponent

    val viewModel: ViewModelProducer by assistedViewModel {
        savedStateHandle -> component.viewModelFactory.create(savedStateHandle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component = FragmentProducerComponent.factory().create(
            (requireActivity() as MainActivity).mainActivityComponent
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}
