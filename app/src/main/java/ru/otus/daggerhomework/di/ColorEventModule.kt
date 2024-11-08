package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Module
class ColorEventModule {

    @ActivityScope
    @Provides
    fun provideColorEventProducer(): MutableStateFlow<Int?> = MutableStateFlow(null)

    @ActivityScope
    @Provides
    fun provideColorEventObserver(flow: MutableStateFlow<Int?>): StateFlow<Int?> = flow.asStateFlow()
}