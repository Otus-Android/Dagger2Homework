package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow

/**
 * @author Юрий Польщиков on 08.08.2021
 */
interface FlowObserver<T> {

    val valueFlow: Flow<T>

    suspend fun emitValue(value: T)
}
