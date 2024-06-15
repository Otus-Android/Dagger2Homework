package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.annotation.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class ColorEventSource @Inject constructor() {
    val events = MutableStateFlow<Int?>(null)
}
