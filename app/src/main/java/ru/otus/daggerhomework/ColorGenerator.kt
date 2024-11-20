package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import java.util.*

@JvmInline
value class Color(@ColorInt val number: Int)

interface ColorGenerator {

    fun generateColor(): ru.otus.daggerhomework.Color
}

class ColorGeneratorImpl : ColorGenerator {

    override fun generateColor(): ru.otus.daggerhomework.Color {
        val rnd = Random()
        return Color(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        )
    }
}