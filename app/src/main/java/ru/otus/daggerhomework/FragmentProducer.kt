package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject lateinit var app: Application

    lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        fragmentProducerComponent =
            DaggerFragmentProducerComponent
                .factory()
                .create((requireActivity().application as App).applicationComponent)

        fragmentProducerComponent.inject(this)

        Log.d("FragmentProducer", app.toString())

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
        }
    }
}