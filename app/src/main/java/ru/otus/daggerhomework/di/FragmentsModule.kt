package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.presentation.ColorGenerator
import ru.otus.daggerhomework.presentation.ColorGeneratorImpl

@Module(subcomponents = [FragmentProducerComponent::class, FragmentReceiverComponent::class])
interface FragmentsModule {

    @Binds
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator

}