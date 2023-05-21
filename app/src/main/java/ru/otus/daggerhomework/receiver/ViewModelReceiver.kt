package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelReceiver(
    private val context: Context,
    private val stateFlow: MutableStateFlow<Int>
):ViewModel() {

    private val _receiver = MutableStateFlow(value = 0)
    val receiver: StateFlow<Int> get() = _receiver.asStateFlow()


    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            _receiver.value = stateFlow.value
        }
    }
}