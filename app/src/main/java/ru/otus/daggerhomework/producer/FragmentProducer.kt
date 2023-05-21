package ru.otus.daggerhomework.producer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.MainActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.receiver.FragmentReceiver
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducerFactory: ViewModelProducerFactory
    private lateinit var viewModelProducer: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initDagger()
        viewModelProducer = ViewModelProvider(this,viewModelProducerFactory).get(ViewModelProducer::class.java)
        return inflater.inflate(R.layout.fragment_a, container, false)

    }

    private fun initDagger(){
        DaggerFragmentProducerComponent.factory().create((activity as MainActivity).mainActivityComponent).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            viewModelProducer.generateColor()
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentReceiver())
                .commit()
        }
    }
}