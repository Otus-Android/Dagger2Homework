package ru.otus.daggerhomework.di.fragment

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [FragmentProducerComponentBaseModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {

        fun create(): FragmentProducerComponent
    }
}

@Module
interface FragmentProducerComponentBaseModule {

    @Binds
    fun bindColorGenerator(
        colorGenerator: ColorGeneratorImpl
    ): ColorGenerator
}