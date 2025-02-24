package ru.otus.daggerhomework

sealed class Event {

    class PopulateColorEvent(val color: Int): Event()
}