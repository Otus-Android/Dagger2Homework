package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.presentation.ColorGenerator
import ru.otus.daggerhomework.presentation.ColorGeneratorImpl
import ru.otus.daggerhomework.presentation.FragmentProducer

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