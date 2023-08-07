package ru.otus.daggerhomework.presentation.producer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.producer.FragmentProducerComponent
import ru.otus.daggerhomework.presentation.provider
import javax.inject.Inject

/**
 * `Fragment`-а поставления цветов
 */
class FragmentProducer : Fragment() {

    @Inject
    lateinit var producer: ViewModelProducer

    override fun onAttach(context: Context) {
        super.onAttach(context)
        FragmentProducerComponent.create(provider().mainActivityComponent).inject(this)
        lifecycle.addObserver(producer)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_a, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener { producer.generateColor() }
    }
}