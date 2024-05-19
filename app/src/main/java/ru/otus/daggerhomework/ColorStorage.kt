package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

private val colorStateFlow = MutableStateFlow<Int?>(null)

interface SetColorRepository {
    fun setColor(@ColorInt color: Int)
}

class SetColorRepositoryImpl @Inject constructor(): SetColorRepository {
    override fun setColor(@ColorInt color: Int) {
        colorStateFlow.update { color }
    }
}

interface GetColorRepository {
    fun getColor(): StateFlow<Int?>
}

class GetColorRepositoryImpl @Inject constructor(): GetColorRepository {
    override fun getColor(): MutableStateFlow<Int?> = colorStateFlow
}
