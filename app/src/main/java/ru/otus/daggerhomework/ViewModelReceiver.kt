package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorObserver: StateFlow<Int?>,
) {

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _colorUiStateFlow: MutableStateFlow<Int?> = MutableStateFlow(null)
    val colorUiStateFlow = _colorUiStateFlow.asStateFlow()

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        scope.launch {
            colorObserver.collect { color ->
                color?.let {
                    _colorUiStateFlow.value = color
                    Toast.makeText(context, "Color $color received", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun onCleared() {
        scope.cancel()
    }
}