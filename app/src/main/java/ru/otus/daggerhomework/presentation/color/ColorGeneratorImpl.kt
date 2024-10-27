package ru.otus.daggerhomework.presentation.color

import android.graphics.Color
import java.util.Random
import javax.inject.Inject


class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}