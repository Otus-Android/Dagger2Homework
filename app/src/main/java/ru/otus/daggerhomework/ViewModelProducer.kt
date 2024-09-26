package ru.otus.daggerhomework

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val eventBus: EventBus
) : ViewModel() {

    fun generateColor() = viewModelScope.launch {
        val nextColor = colorGenerator.generateColor()
        Log.d("VM", "color $nextColor")
        eventBus.send(nextColor)
    }

    class Factory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        private val eventBus: EventBus
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.d("FACTORY", "eventBus $eventBus")
            return if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
                ViewModelProducer(colorGenerator, eventBus) as T
            } else {
                throw IllegalStateException("Unknown ViewModel class")
            }
        }
    }
}