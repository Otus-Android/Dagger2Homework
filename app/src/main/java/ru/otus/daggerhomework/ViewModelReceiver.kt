package ru.otus.daggerhomework

import kotlinx.coroutines.flow.SharedFlow

class ViewModelReceiver(
    val eventSource: SharedFlow<Event>
)