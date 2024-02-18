package ru.otus.daggerhomework.colorexchanger

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ColorListener @Inject constructor(
    private val colorExchanger: ColorExchanger,
) {
    fun getColorFlow(): Flow<Int?> {
        return colorExchanger.getColorFlow()
    }
}