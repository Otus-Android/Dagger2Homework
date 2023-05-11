package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import ru.otus.daggerhomework.di.FragmentProducerComponent
import javax.inject.Inject

private const val TAG = "FragmentProducer"

class FragmentProducer : Fragment() {

    @Inject lateinit var app: Application
    @Inject lateinit var eventBus: EventBus
    @Inject lateinit var colorGenerator: ColorGenerator
    @Inject lateinit var viewModelFactory: ViewModelProducerFactory

    private val viewModelProducer by viewModels<ViewModelProducer> {
        //ViewModelProducerFactory(eventBus, colorGenerator, requireActivity())
        viewModelFactory
    }

    lateinit var fragmentProducerComponent: FragmentProducerComponent

    override fun onCreate(savedInstanceState: Bundle?) {

        fragmentProducerComponent =
            DaggerFragmentProducerComponent
                .factory()
                .create((requireActivity() as MainActivity).mainActivityComponent)

        fragmentProducerComponent.inject(this)

        super.onCreate(savedInstanceState)
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
            //отправить результат через livedata в другой фрагмент
            viewModelProducer.generateColor()
        }
    }
}