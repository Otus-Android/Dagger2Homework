package ru.otus.daggerhomework.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.scope.ActivityScope

@Module
object MainActivityModule {

    @Provides
    @ActivityScope
    fun provideMutableColorStateFlow(): MutableStateFlow<Int?> {
        return MutableStateFlow(null)
    }

    @Provides
    @ActivityScope
    fun provideColorStateFlow(
        mutableStateFlow: MutableStateFlow<Int?>
    ): StateFlow<Int?> {
        return mutableStateFlow.asStateFlow()
    }
}