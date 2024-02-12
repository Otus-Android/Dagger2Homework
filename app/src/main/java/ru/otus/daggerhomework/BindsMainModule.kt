package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface BindsMainModule {

  @Binds fun getProducerStateObserver(observer: StateObserverImpl): ProducerStateObserver

  @Binds fun getReceiverStateObserver(observer: StateObserverImpl): ReceiverStateObserver
}
