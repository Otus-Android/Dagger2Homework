package ru.otus.daggerhomework.colorproducer

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.main.MainActivityScope
import javax.inject.Inject


interface IColorHandler {
    val tickFlow: StateFlow<Int>
}

@MainActivityScope
class ColorProducer @Inject constructor() : IColorHandler {
    private val _tickFlow: MutableStateFlow<Int> = MutableStateFlow(value = COLOR_DEFAULT)
    override val tickFlow: StateFlow<Int> = _tickFlow.asStateFlow()

    fun setColor(value: Int) {
        _tickFlow.value = value
    }

    companion object {
        const val COLOR_DEFAULT = 0
    }
}