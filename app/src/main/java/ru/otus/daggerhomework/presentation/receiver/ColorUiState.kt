package ru.otus.daggerhomework.presentation.receiver

import androidx.annotation.ColorInt

/**
 * UI состояние экрана цвета
 */
sealed interface ColorUiState {

    /** Бездействие */
    object Idle : ColorUiState

    /**
     * Значение цвета
     *
     * @property color числовое представление цвета в виде
     */
    data class Success(@ColorInt val color: Int) : ColorUiState

    /**
     * Ошибка
     *
     * @property message сообщение об ошибке
     */
    data class Error(val message: String) : ColorUiState
}
