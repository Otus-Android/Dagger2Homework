package ru.otus.daggerhomework.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.scopes_and_qualifiers.ActivityScope

@Module
class ActivityComponentModule {

    @ActivityScope
    @Provides
    fun provideEventCache(): MutableStateFlow<Int> = MutableStateFlow(0)
}