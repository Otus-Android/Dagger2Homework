package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Module
interface MainActivityModule {
    
    @ActivityScope
    @Binds
    fun bindColorState(
        mutableState: MutableStateFlow<@JvmSuppressWildcards ColorState>
    ): StateFlow<@JvmSuppressWildcards ColorState>
    
    companion object {
    
        @ActivityScope
        @Provides
        fun providesMutableColorState(): MutableStateFlow<ColorState> = MutableStateFlow(ColorState.Init)
    }
    
}