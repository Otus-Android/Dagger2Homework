package ru.otus.daggerhomework

import android.graphics.Color
import android.util.Log
import androidx.annotation.ColorInt
import java.util.*

interface ColorGenerator {

    @ColorInt
    fun generateColor(): Int
}

class ColorGeneratorImpl : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        val color = Color.argb(
            255,
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256)
        )
        return color
    }
}