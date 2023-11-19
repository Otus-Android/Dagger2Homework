package ru.otus.daggerhomework

sealed class State {
    class Error(val throwable: Throwable) : State()
    class Success(val color: Int): State()
}
