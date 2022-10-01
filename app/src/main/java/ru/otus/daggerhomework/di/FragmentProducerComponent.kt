package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer

@Subcomponent(modules = [ProducerFragmentModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

}

@Module
interface ProducerFragmentModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}