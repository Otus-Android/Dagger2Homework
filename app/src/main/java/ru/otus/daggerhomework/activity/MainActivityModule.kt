package ru.otus.daggerhomework.activity

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.scope.ActivityScope

@Module
object MainActivityModule {

    @ActivityScope
    @Provides
    fun provideMutableStateColor(): MutableStateFlow<Int?> =
        MutableStateFlow(null)

    @ActivityScope
    @Provides
    fun updateColor(colorState: MutableStateFlow<Int?>): StateFlow<Int?> =
        colorState.asStateFlow()
}
