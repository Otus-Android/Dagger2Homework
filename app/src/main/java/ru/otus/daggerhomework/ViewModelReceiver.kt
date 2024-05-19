package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ViewModelReceiver(
    private val colorEventSource: ColorEventSource,
    private val context: Context
) : ViewModel() {

    private val _colorEventFlow = MutableStateFlow<Int?>(null)

    init {
        observeColors()
    }

    val colorEventFlow = _colorEventFlow.asStateFlow()

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        colorEventSource.events
            .filterNotNull()
            .onEach { color ->
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                _colorEventFlow.tryEmit(color)
            }.launchIn(viewModelScope)
    }
}