package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.flow.*
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

interface EventBusReceiver {
    val events: Flow<Int>
}

interface EventBusProducer {
    fun dispatch(value: Int)
}

@ActivityScope
class EventBusImpl @Inject constructor() : EventBusReceiver, EventBusProducer {

    private val mutableStateFlow = MutableStateFlow(Color.BLACK)
    override val events = mutableStateFlow.asStateFlow()

    override fun dispatch(value: Int) {
        mutableStateFlow.tryEmit(value)
    }
}