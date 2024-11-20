package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import ru.otus.daggerhomework.Color
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver

@Module
object ViewModelProducerModule {
    @Provides
    fun provideViewModelProducerFactory(
        colorGenerator: ColorGenerator,
        publisher: FlowCollector<Color>,
        @ActivityContext context: Context
    ): ViewModelProvider.Factory = ViewModelProducer.factory(colorGenerator, publisher, context)
}