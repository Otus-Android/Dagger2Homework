package ru.otus.daggerhomework.colorexchanger

import ru.otus.daggerhomework.ColorGenerator
import javax.inject.Inject

class ColorUpdater @Inject constructor(
    private val colorExchanger: ColorExchanger,
    private val colorGenerator: ColorGenerator
) {
    fun update(color: Int) {
        colorExchanger.updateColor(colorGenerator.generateColor())
    }
}