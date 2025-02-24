package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val eventSource: MutableSharedFlow<Event>
): ViewModel() {

    fun generateColor() {

        viewModelScope.launch {
            eventSource.emit(Event.PopulateColorEvent(colorGenerator.generateColor()))
        }
    }
}