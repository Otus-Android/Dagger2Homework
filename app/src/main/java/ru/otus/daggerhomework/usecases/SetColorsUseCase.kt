package ru.otus.daggerhomework.usecases

interface SetColorsUseCase {
    operator fun invoke(color: Int)
}