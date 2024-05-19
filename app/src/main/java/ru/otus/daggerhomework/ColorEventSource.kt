package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.annotation.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class ColorEventSource @Inject constructor() {
    private val _events = MutableStateFlow<Int?>(null)
    val events = _events.asStateFlow()

    fun sentNewColor(color: Int) {
        _events.tryEmit(color)
    }
}
