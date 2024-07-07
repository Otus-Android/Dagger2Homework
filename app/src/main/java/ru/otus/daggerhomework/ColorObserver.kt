package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScope
class ColorObserver @Inject constructor() {
    private val _color = MutableStateFlow<Int?>(null)
    val color = _color.asStateFlow()

    fun postColor(color: Int) {
        _color.value = color
    }
}