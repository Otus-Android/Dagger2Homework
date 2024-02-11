package ru.otus.daggerhomework

import android.content.Context

interface StateFlowDependency {

  fun getStateFlow(): StateObserver

  @ApplicationContext fun context(): Context

  @ActivityContext fun getContext(): Context
}
