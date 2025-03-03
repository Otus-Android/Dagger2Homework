package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ReceiverViewModel(
    private val colorStateObserver: StateFlow<Int?>
): ViewModel()
 {
    private val _colorFlow = MutableStateFlow<Int?>(null)
    val colorFlow: StateFlow<Int?> = _colorFlow.asStateFlow()

    fun observeColors() {
        colorStateObserver
            .onEach {
                _colorFlow.value = it
            }
            .launchIn(viewModelScope)
    }


    class Factory @Inject constructor(
        private val colorEventObserver: StateFlow<Int?>
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ReceiverViewModel(colorEventObserver) as T
    }
}