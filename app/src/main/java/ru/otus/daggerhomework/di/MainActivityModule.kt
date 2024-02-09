package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.util.EventFlow
import ru.otus.daggerhomework.util.EventFlowImpl
import ru.otus.daggerhomework.util.EventSender

@Module
interface MainActivityModule {

    @Binds fun bindEventFlow(eventFlowImpl: EventFlowImpl): EventFlow

    @Binds fun bindEventSender(eventFlowImpl: EventFlowImpl): EventSender
}
