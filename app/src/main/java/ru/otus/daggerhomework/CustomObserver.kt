package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@ActivityScope
class CustomObserver @Inject constructor() {

    private val colorFlow = MutableStateFlow(Color.argb(255, 255, 255, 255))

    fun produceColor(color: Int) {
        colorFlow.value = color
    }

    fun observeColor(): StateFlow<Int> = colorFlow
}