package ru.otus.daggerhomework

sealed class ProducerEvents {
    object Empty: ProducerEvents()
    object OpenReceiver: ProducerEvents()
}