package ru.otus.daggerhomework.presentation.color

import androidx.annotation.ColorInt

/**
 * Генератор цветов
 */
interface ColorGenerator {

    /** Сгенерировать числовое представление цвета в виде [Int] */
    @ColorInt
    fun generateColor(): Int
}