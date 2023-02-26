package ru.otus.daggerhomework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.component.FragmentProducerComponent
import ru.otus.daggerhomework.viewmodel.ViewModelProducer
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var videModelProducer: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentProducerComponent
            .create((activity as MainActivity).getComponent())
            .inject(this)
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            videModelProducer.generateColor()
        }
    }
}