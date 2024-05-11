package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

interface ColorStorageRepository {
    fun setColor(@ColorInt color: Int)
    fun getColor(): StateFlow<Int?>
}

class ColorStorageRepositoryImpl @Inject constructor() : ColorStorageRepository {

    private val colorStateFlow = MutableStateFlow<Int?>(null)

    override fun setColor(@ColorInt color: Int) {
        colorStateFlow.update { color }
    }

    override fun getColor(): MutableStateFlow<Int?> = colorStateFlow
}
