package ru.otus.daggerhomework.presentation.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.presentation.viewmodels.ReceiveColorFlow.Companion.INIT_VALUE

interface SentColor {
    fun sent(color: Int)
}

interface ReceiveColorFlow {
    val flow: StateFlow<Int>
    companion object{
        const val INIT_VALUE = 0
    }
}

class ActivityViewModel : ReceiveColorFlow, SentColor {
    private val _colorFlow = MutableStateFlow(INIT_VALUE)
    override fun sent(color: Int) {
        _colorFlow.tryEmit(color)
    }

    override val flow: StateFlow<Int>
        get() = _colorFlow
}