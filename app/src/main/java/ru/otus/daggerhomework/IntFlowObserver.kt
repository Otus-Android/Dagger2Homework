package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

/**
 * @author Юрий Польщиков on 08.08.2021
 */
class IntFlowObserver @Inject constructor() : FlowObserver<Int> {

    private val eventFlow = MutableSharedFlow<Int>()

    override val valueFlow: Flow<Int> = eventFlow

    override suspend fun emitValue(value: Int) {
        eventFlow.emit(value)
    }
}
