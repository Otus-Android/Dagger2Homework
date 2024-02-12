package ru.otus.daggerhomework

import android.content.Context

interface StateFlowDependency {

  fun getStateFlow(): ProducerStateObserver

  fun getReceiverStateObserver(): ReceiverStateObserver

  @ApplicationContext fun context(): Context

  @ActivityContext fun getContext(): Context
}
