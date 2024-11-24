package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.application.ActivityScope
import java.util.Random
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
    val state: StateFlow<Int>
    fun setColor(color: Int)
}

@ActivityScope
class ColorStateImpl @Inject constructor() : ColorState {

    private val _state: MutableStateFlow<Int> = MutableStateFlow(0)
    override val state: StateFlow<Int> = _state.asStateFlow()

    override fun setColor(color: Int) {
        _state.value = color
    }
}