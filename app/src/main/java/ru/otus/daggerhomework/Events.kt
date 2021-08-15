package ru.otus.daggerhomework

sealed class Events {
    class SetColor(val color: Int) : Events()
    object Empty : Events()
}