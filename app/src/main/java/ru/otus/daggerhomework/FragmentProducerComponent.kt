package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Subcomponent

@Subcomponent
interface FragmentProducerComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }
    fun inject(producerFragment: FragmentProducer)
}

@Module(subcomponents = [FragmentProducerComponent::class])
interface ProducerModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}