package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.R.layout
import ru.otus.daggerhomework.activity.MainActivity
import ru.otus.daggerhomework.producer.di.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProducer.Factory

    private lateinit var viewModel: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentProducerComponent
            .factory()
            .create((activity as MainActivity).mainActivityComponent)
            .inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModelProducer::class.java)
        return inflater.inflate(layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.generateColor()
        }
    }
}