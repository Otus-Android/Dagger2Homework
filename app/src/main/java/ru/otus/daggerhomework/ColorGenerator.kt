package ru.otus.daggerhomework

import android.graphics.Color
import androidx.annotation.ColorInt
import java.util.Random
import javax.inject.Inject

@JvmInline
value class ColorNumber(@ColorInt val number: Int)

interface ColorGenerator {

    fun generateColor(): ColorNumber
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    override fun generateColor(): ColorNumber {
        val rnd = Random()
        return ColorNumber(
            Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        )
    }
}