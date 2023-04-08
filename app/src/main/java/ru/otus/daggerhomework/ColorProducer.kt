package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow

interface ColorProducer {
    val color: Flow<Int>
}