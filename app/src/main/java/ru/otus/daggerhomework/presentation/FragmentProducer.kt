package ru.otus.daggerhomework.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    lateinit var producerComponent: FragmentProducerComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        producerComponent =
            (requireActivity() as MainActivity).mainActivityComponent.producerComponent().create()

        producerComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
            findNavController().navigate(R.id.action_fragmentProducer_to_fragmentReceiver)
        }
    }
}