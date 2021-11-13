package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @Inject
    lateinit var producerComponent: FragmentProducerComponent

    lateinit var viewModel: ViewModelProducer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.producerComponent().create().inject(this)
        viewModel = ViewModelProvider(
            this, ViewModelProducer.Factory(
                producerComponent.colorGenerator(),
                producerComponent.observer(),
                producerComponent.activityContext()
            )
        ).get(ViewModelProducer::class.java)
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

@Module
interface FragmentProducerModule {
    @Binds
    fun colorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    fun activityContext(): Context
    fun observer(): Channel<Result>
    fun inject(producer: FragmentProducer)
    fun colorGenerator(): ColorGenerator

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
}