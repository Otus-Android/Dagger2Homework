package ru.otus.daggerhomework.colorexchanger

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ColorExchangerImpl @Inject constructor() : ColorExchanger {

    private val _colorFlow = MutableStateFlow<Int?>(null)
    private val colorFlow = _colorFlow.asStateFlow()

    override fun updateColor(color: Int) {
        _colorFlow.value = color
    }

    override fun getColorFlow(): Flow<Int?> {
        return colorFlow
    }
}
