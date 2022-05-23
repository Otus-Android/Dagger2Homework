package ru.otus.daggerhomework

interface Event {
    class ShowColor(val color: Int) : Event
}