package ru.otus.daggerhomework.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.EventBusProducer
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.activityComponent
import ru.otus.daggerhomework.viewmodels.ViewModelProducer
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var colorGenerator: ColorGenerator

    @Inject
    lateinit var producer: EventBusProducer

    @Inject
    @ActivityContext
    lateinit var activityContext: Context

    private val viewModel by viewModels<ViewModelProducer> {
        ViewModelProducer.Factory(
            colorGenerator,
            producer,
            activityContext
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent.provideProducerComponent().build().inject(this)
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
            viewModel.generateColor()
        }
    }
}