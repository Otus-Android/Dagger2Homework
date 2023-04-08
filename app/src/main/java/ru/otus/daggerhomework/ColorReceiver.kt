package ru.otus.daggerhomework

interface ColorReceiver {
    suspend fun receiveColor(color: Int)
}