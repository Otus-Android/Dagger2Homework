package ru.otus.daggerhomework.domain

import android.graphics.Color
import java.util.*

class ColorGeneratorImpl : ColorGenerator {

    override fun generateColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}