package ru.otus.daggerhomework

import kotlinx.coroutines.flow.StateFlow

interface StateObserver {
  fun getStateObserver(): StateFlow<Int?>

  suspend fun setState(color: Int)
}
