package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    private val context: Context,
    private val colorState: ColorState,
) : ViewModel() {

    private val _receivedColor: MutableSharedFlow<Int> = MutableSharedFlow(1)
    val receivedColor: SharedFlow<Int> = _receivedColor.asSharedFlow()

    init {
        observeColors()
    }

    private fun observeColors() {
        viewModelScope.launch {
            colorState.state.collect {
                _receivedColor.emit(it)
                if (context !is Application) throw RuntimeException("Application context is required")
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }
        }
    }
}