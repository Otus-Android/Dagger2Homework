package ru.otus.daggerhomework.di.activity

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.LocalEvent

@Module
object ActivityModule {

    @ActivityScope
    @Provides
    fun provideChannel(): Channel<LocalEvent> {
        return Channel()
    }

}