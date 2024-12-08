package ru.otus.daggerhomework.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.FlowCollector
import ru.otus.daggerhomework.ColorNumber
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ViewModelProducer

@Module
object ViewModelProducerModule {
    @Provides
    @FragmentScope
    @JvmSuppressWildcards
    fun provideViewModelProducerFactory(
        colorGenerator: ColorGenerator,
        @Publisher publisher: FlowCollector<ColorNumber>,
        @ActivityContext context: Context
    ): ViewModelProvider.Factory = ViewModelProducer.factory(colorGenerator, publisher, context)
}