package ru.otus.daggerhomework

import android.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


open class CustomObserver {
    protected val colorFlow = MutableStateFlow(Color.argb(255, 255, 255, 255))

    fun observeColor(): StateFlow<Int> = colorFlow
}

@ActivityScope
class CustomProducer @Inject constructor(): CustomObserver() {
    fun produceColor(color: Int) {
        colorFlow.value = color
    }
}