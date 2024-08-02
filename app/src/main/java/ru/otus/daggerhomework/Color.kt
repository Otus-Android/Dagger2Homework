package ru.otus.daggerhomework

sealed interface Color {
    data class Available(val value: Int) : Color
    object Unavailable : Color
}