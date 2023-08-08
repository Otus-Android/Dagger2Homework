package ru.otus.daggerhomework.presentation.color

import android.graphics.Color
import java.util.Random
import javax.inject.Inject

/**
 * Реализация [ColorGeneratorImpl]
 */
class ColorGeneratorImpl @Inject constructor() : ColorGenerator {

    private val rnd = Random()

    override fun generateColor() = Color.argb(255, generateNext(), generateNext(), generateNext())

    private fun generateNext() = rnd.nextInt(256)
}