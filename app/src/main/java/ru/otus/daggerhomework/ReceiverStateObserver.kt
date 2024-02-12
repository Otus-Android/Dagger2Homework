package ru.otus.daggerhomework

import kotlinx.coroutines.flow.StateFlow

interface ReceiverStateObserver {
    fun getStateObserver(): StateFlow<Int?>
}