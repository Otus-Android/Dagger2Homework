package ru.otus.daggerhomework

import java.util.UUID

sealed class Event {
    data class PopulateColor(
        val color: Int
    ) : Event()
}