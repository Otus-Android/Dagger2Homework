package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.graphics.Color
import kotlinx.coroutines.flow.collect
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val colorStorageRepository: ColorStorageRepository,
): ViewModel() {

    private val _state = MutableStateFlow(Color.WHITE)
    val state = _state.asStateFlow()

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        viewModelScope.launch {
            colorStorageRepository.getColor()
                .onEach { color ->
                    if (color != null) {
                        _state.update { color }
                        Toast.makeText(context, "Color $color received", Toast.LENGTH_LONG).show()
                    }
                }.collect()
        }
    }
}
