package ru.otus.daggerhomework

import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateObserverImpl @Inject constructor() : ProducerStateObserver, ReceiverStateObserver {
  private val stateFlow = MutableStateFlow<Int?>(null)

  override fun getStateObserver(): StateFlow<Int?> {
    return stateFlow.asStateFlow()
  }

  override suspend fun setState(color: Int) {
    stateFlow.emit(color)
  }
}
