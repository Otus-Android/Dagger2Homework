package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.fragments.BaseViewModel
import ru.otus.daggerhomework.fragments.producer.FragmentProducer
import ru.otus.daggerhomework.fragments.producer.ViewModelProducer
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorGeneratorImpl

@FragmentScope
@Subcomponent(
    modules = [
        FragmentProducerUtilsModule::class,
        FragmentProducerViewModel::class
    ]
)

interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerUtilsModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(generator: ColorGeneratorImpl): ColorGenerator
}

@Module
interface FragmentProducerViewModel {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun bindFragmentProducerViewModel(viewModel: ViewModelProducer): BaseViewModel
}
