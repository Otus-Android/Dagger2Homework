package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface FragmentProducerModule {

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun bindColorObserver(colorObserver: ColorObserverImpl): ColorObserver

    @Binds
    fun bindImmutableColorObserver(colorObserver: ColorObserverImpl): ImmutableColorObserver
}