package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import java.util.*

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGeneratorImpl : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}