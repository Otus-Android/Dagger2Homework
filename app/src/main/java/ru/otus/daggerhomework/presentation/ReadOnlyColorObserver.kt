package ru.otus.daggerhomework.presentation

import kotlinx.coroutines.flow.StateFlow

interface ReadOnlyColorObserver {
    val colorFlow: StateFlow<Int>
}