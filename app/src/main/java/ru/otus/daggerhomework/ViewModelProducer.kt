package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val colorEventProducer: MutableStateFlow<Int?>
): ViewModel() {

    fun generateColor() {
        colorEventProducer.value = colorGenerator.generateColor()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        private val colorEventProducer: MutableStateFlow<Int?>
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ViewModelProducer(colorGenerator, colorEventProducer) as T
    }
}