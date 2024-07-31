package ru.otus.daggerhomework.presentation.receiver

import androidx.annotation.ColorInt

sealed interface ColorUiState {
    object Idle : ColorUiState
    data class Success(@ColorInt val color: Int) : ColorUiState
    data class Error(val message: String) : ColorUiState
}