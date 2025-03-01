package ru.otus.daggerhomework

sealed interface Events {
    data object InitialEvent: Events
    data object Event: Events
}