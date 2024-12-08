package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.ColorNumber
import javax.inject.Qualifier



@Module
object ColorPipelineModule {
    @Provides
    @AppScope
    fun colorPipeline(): MutableSharedFlow<ColorNumber> = MutableSharedFlow()

    @Provides
    @Publisher
    @JvmSuppressWildcards
    fun publisher(pipeline: MutableSharedFlow<ColorNumber>): FlowCollector<ColorNumber> = pipeline

    @Provides
    @Subscriber
    fun subscriber(pipeline: MutableSharedFlow<ColorNumber>): Flow<ColorNumber> = pipeline
}

@Qualifier
annotation class Publisher

@Qualifier
annotation class Subscriber