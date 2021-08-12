package ru.otus.daggerhomework.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelProducer

@Module(subcomponents = [FragmentProducerComponent::class])
class FragmentProducerModuleProv {
    @Provides
    fun provideViewModelProducer(colorGenerator: ColorGenerator, context: Context): ViewModelProducer {
        return ViewModelProducer(colorGenerator, context)
    }

    @Provides
    fun provideColorGenerator(): ColorGenerator {
        return ColorGeneratorImpl()
    }
}