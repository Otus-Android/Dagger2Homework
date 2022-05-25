package ru.otus.daggerhomework

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun providesColorStateFlow(): MutableStateFlow<Color> = MutableStateFlow(Color(0))
}