package ru.otus.daggerhomework.util

import kotlinx.coroutines.flow.Flow

interface EventFlow {

    fun events(): Flow<Event>
}


