package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface StateObserver {
    fun getStateObserver(): StateFlow<Int?>

    suspend fun setState(color: Int)
}

class StateObserverImpl @Inject constructor() : StateObserver {
    private val stateFlow = MutableStateFlow<Int?>(null)

    override fun getStateObserver(): StateFlow<Int?> {
        return stateFlow.asStateFlow()
    }

    override suspend fun setState(color: Int) {
        stateFlow.emit(color)
    }
}
