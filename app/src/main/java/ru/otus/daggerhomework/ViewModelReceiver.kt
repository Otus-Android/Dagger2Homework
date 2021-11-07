package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelReceiver(
    private val context: Context,
    private val colorObserver: ColorObserver
) : ViewModel() {

    private val _color = MutableStateFlow(0)
    val color: StateFlow<Int> = _color

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            while (true) {
                val color = colorObserver.receive()
                Toast.makeText(context, "Color received: $color", Toast.LENGTH_SHORT).show()
                _color.value = color
            }
        }
    }
}