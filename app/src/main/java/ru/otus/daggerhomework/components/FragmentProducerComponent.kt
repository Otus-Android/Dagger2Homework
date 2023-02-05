package ru.otus.daggerhomework.components

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.producer.ViewModelFactory
import javax.inject.Singleton

@Subcomponent(modules = [ColorModule::class])
@Singleton
interface FragmentProducerComponent {
    fun injectToFragmentProducer(fragmentProducer: FragmentProducer)
    fun viewModelFactory(): ViewModelFactory
}

@Module
interface ColorModule{
    @Binds
    @Singleton
    fun bindColorGenerator(cgImpl: ColorGeneratorImpl): ColorGenerator
}