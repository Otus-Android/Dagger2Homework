package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ColorObserver
import ru.otus.daggerhomework.ColorObserverImpl

@Module(subcomponents = [FragmentProducerComponent::class])
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun bindColorObserver(colorObserver: ColorObserverImpl): ColorObserver
}