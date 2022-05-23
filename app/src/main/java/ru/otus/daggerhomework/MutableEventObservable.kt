package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.otus.daggerhomework.common.ActivityScope
import javax.inject.Inject

@ActivityScope
class MutableEventObservable @Inject constructor() : EventObservable {

    override val events get() = mEvents.asSharedFlow()
    private val mEvents = MutableSharedFlow<Event>(extraBufferCapacity = 1)

    fun post(event: Event) {
        mEvents.tryEmit(event)
    }

}