package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Subcomponent

@Module
interface FragmentProducerModule {
    @Binds
    fun bindsColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)

    fun producerViewModel(): ViewModelProducer.Factory
}