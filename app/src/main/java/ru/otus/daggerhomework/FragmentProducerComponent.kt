package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap

@FragmentScoped
@Component(dependencies = [MainActivityComponent::class], modules = [ProducerModule::class])
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}

@Module
interface ProducerModule {
    @Binds
    @FragmentScoped
    fun bindColorGenerator(generator: ColorGeneratorImpl): ColorGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    abstract fun viewModelProducer(viewModel: ViewModelProducer): ViewModel
}

