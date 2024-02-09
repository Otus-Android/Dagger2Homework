package ru.otus.daggerhomework.util

interface EventSender {

    suspend fun send(event: Event)
}
