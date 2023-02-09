package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.FragmentProducerComponent

class FragmentProducer : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    lateinit var producerComponent: FragmentProducerComponent
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        producerComponent = (requireActivity() as MainActivity).mainActivityComponent.fragmentProducerComponent()

        view.findViewById<Button>(R.id.button).setOnClickListener {

            producerComponent.producer().postValue()

            //отправить результат через livedata в другой фрагмент
        }
    }
}