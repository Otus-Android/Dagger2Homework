package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow

@Module
object ColorPipelineModule {
    @Provides
    @ActivityScope
    fun colorPipeline(): MutableSharedFlow<ru.otus.daggerhomework.Color> = MutableSharedFlow<ru.otus.daggerhomework.Color>()

    @Provides
    fun publisher(pipeline: MutableSharedFlow<ru.otus.daggerhomework.Color>): FlowCollector<ru.otus.daggerhomework.Color> = pipeline

    @Provides
    fun subscriber(pipeline: MutableSharedFlow<ru.otus.daggerhomework.Color>): Flow<ru.otus.daggerhomework.Color> = pipeline
}