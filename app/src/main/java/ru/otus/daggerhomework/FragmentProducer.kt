package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Inject
import javax.inject.Scope

class FragmentProducer : Fragment() {

    @Inject
    lateinit var viewModelProducerFactory: ViewModelProducerFactory
    private val viewModelProducer by viewModels<ViewModelProducer> { viewModelProducerFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DaggerFragmentProducerComponent
            .factory()
            .create((requireActivity() as MainActivity).mainActivityComponent)
            .inject(this)
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

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
    fun provideColorGenerator(): ColorGenerator
    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerModule {
    @FragmentScope
    @Binds
    fun colorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}

@Scope
annotation class FragmentScope