package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import java.util.*
import javax.inject.Inject

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}

interface ColorState {
    val state: SharedFlow<Int>
    fun setColor(color: Int)
}


class ColorStateImpl @Inject constructor() : ColorState {

    private val _state: MutableSharedFlow<Int> = MutableSharedFlow(1)
    override val state: SharedFlow<Int> = _state.asSharedFlow()

    override fun setColor(color: Int) {
        _state.tryEmit(color)
    }
}