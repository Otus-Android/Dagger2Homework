package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.component.ProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment(R.layout.fragment_a) {
    @Inject
    lateinit var viewModelProducer: ViewModelProducer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ProducerComponent.getProducerComponent((requireActivity() as MainActivity).getMainActivityComponent())
            .inject(this)
    }
}