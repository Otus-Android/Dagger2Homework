package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.EventBus
import ru.otus.daggerhomework.EventBusImpl

@Module
interface EventBusModule {

    @MainScope
    @Binds
    fun bindsEventBus(impl: EventBusImpl): EventBus
}