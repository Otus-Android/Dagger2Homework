package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import java.util.*
import javax.inject.Inject

interface IColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGenerator @Inject constructor() : IColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}