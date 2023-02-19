package ru.otus.daggerhomework.components

import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.producer.ViewModelFactory
import javax.inject.Singleton

@Subcomponent(modules = [ColorModule::class])
interface FragmentProducerComponent {
    fun inject(fragmentProducer: FragmentProducer)
    fun provideViewModelFactory(): ViewModelFactory

    @Subcomponent.Factory
    interface Factory{
        fun create(): FragmentProducerComponent
    }
}

@Module
interface ColorModule{
    @Binds
    fun bindColorGenerator(cgImpl: ColorGeneratorImpl): ColorGenerator
}