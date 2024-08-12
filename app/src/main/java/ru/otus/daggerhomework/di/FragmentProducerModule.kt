package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl

@Module(subcomponents = [FragmentProducerComponent::class])
object FragmentProducerModule {

    @Provides
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}