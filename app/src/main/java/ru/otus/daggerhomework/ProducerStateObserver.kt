package ru.otus.daggerhomework

interface ProducerStateObserver {
  suspend fun setState(color: Int)
}
