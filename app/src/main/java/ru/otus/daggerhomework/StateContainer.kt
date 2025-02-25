package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface StateContainer {
    fun setStateFlow(value: Int)
    fun getState(): StateFlow<Int>
}

class StateContainerImpl @Inject constructor() : StateContainer {
    private val _stateFlow = MutableStateFlow(-1)
    private val stateFlow: StateFlow<Int> = _stateFlow

    override fun setStateFlow(value: Int) {
        _stateFlow.value = value
    }

    override fun getState(): StateFlow<Int> = stateFlow
}