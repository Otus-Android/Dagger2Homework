package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.presentation.ColorGenerator
import ru.otus.daggerhomework.presentation.ColorGeneratorImpl
import ru.otus.daggerhomework.presentation.ReadOnlyColorObserver
import ru.otus.daggerhomework.presentation.MutableColorObserver

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface FragmentsModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

    @Binds
    fun bindColorObserver(mutableColorObserver: MutableColorObserver): ReadOnlyColorObserver

}