package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val flow: MutableStateFlow<Int?>
) {

    private val _colorFlow: MutableStateFlow<Int?> = MutableStateFlow(null)
    val colorFlow: StateFlow<Int?> = _colorFlow
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        scope.launch {
            flow.collect { color ->
                color?.let {
                    _colorFlow.value = it
                    Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun onCleared() {
        scope.cancel()
    }
}