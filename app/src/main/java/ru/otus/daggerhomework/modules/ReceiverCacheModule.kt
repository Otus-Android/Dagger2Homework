package ru.otus.daggerhomework.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentScope


@Module
object ReceiverCacheModule {

    @FragmentScope
    @Provides
    fun provideAbstractCache(mutableStateFlow: MutableStateFlow<Int>): StateFlow<Int> {
        return mutableStateFlow
    }
}