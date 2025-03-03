package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProducerViewModel(
    private val colorGenerator: ColorGenerator,
    private val colorEventProducer: MutableStateFlow<Int?>
): ViewModel() {

    fun generateColor() {
        colorEventProducer.value = colorGenerator.generateColor()
    }


    class Factory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        private val colorEventProducer: MutableStateFlow<Int?>
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ProducerViewModel(colorGenerator, colorEventProducer) as T
    }
}