package ru.otus.daggerhomework

import javax.inject.Inject
import kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
import kotlinx.coroutines.flow.MutableSharedFlow
import ru.otus.daggerhomework.scopes.ActivityScope

@ActivityScope
class ColorEventSource @Inject constructor() {
    val events = MutableSharedFlow<Int>(
        replay = 1,
        extraBufferCapacity = 1,
        onBufferOverflow = DROP_OLDEST
    )
}
