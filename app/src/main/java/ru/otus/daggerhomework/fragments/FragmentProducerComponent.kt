package ru.otus.daggerhomework.fragments

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.colorproducer.ColorGenerator
import ru.otus.daggerhomework.colorproducer.ColorGeneratorImpl
import javax.inject.Singleton

@Module
interface FragmentProducerModule {
    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}

@Singleton
@FragmentScope
@Subcomponent(modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)
}