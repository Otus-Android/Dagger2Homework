package ru.otus.daggerhomework.usecases

import kotlinx.coroutines.flow.StateFlow

interface ProvideColorsUseCase {
    operator fun invoke(): StateFlow<Int>
}