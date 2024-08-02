package ru.otus.daggerhomework

import android.graphics.Color
import java.util.Random
import javax.inject.Inject

interface ColorGenerator {

    fun generateColor(): GeneratedColor
}

class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    override fun generateColor(): GeneratedColor {
        val rnd = Random()
        return GeneratedColor.Success(
            Color.argb(
                255,
                rnd.nextInt(256),
                rnd.nextInt(256),
                rnd.nextInt(256)
            )
        )
    }
}