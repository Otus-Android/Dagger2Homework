package ru.otus.daggerhomework.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorObserver: ColorObserver
) {

    private val _colorFlow = MutableStateFlow<Int?>(null)
    val colorFlow: StateFlow<Int?> = _colorFlow

    suspend fun observeColors() {
        colorObserver.getColorFlow().collect { color ->
            if (color != null) {
                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }

            _colorFlow.value = color
        }
    }
}