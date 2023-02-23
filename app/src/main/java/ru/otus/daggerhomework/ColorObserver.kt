package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.PerActivity
import javax.inject.Inject

interface ColorProducer {
    fun updateColor(@ColorInt color: Int)
}

interface ColorReceiver {
    fun getColorFlow(): StateFlow<Int>
}

@PerActivity
class ColorObserver @Inject constructor() : ColorProducer, ColorReceiver {

    private val _colorFlow = MutableStateFlow(0)

    override fun getColorFlow(): StateFlow<Int> {
        return _colorFlow.asStateFlow()
    }

    override fun updateColor(color: Int) {
        _colorFlow.value = color
    }
}