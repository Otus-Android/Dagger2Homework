package ru.otus.daggerhomework.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.otus.daggerhomework.di.IO

@Module
interface ReceiverModule {
    companion object {

        @IO
        @Provides
        fun providesIoDispatcher(): CoroutineDispatcher {
            return Dispatchers.IO
        }
    }
}