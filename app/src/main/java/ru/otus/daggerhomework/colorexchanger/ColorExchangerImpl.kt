package ru.otus.daggerhomework.colorexchanger

import android.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.ColorGenerator
import javax.inject.Inject

class ColorExchangerImpl @Inject constructor(
    private val colorGenerator: ColorGenerator
) : ColorExchanger {

    private val _colorFlow = MutableStateFlow<Int?>(null)
    private val colorFlow = _colorFlow.asStateFlow()

    override fun updateColor(color: Int) {
        _colorFlow.value = colorGenerator.generateColor()
    }

    override fun getColorFlow(): Flow<Int?> {
        return colorFlow
    }
}