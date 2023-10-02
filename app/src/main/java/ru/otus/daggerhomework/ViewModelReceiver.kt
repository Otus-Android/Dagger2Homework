package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val flow: StateFlow<Int?>,
) {
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    private val _colorFlow: MutableStateFlow<Int?> = MutableStateFlow(null)
    val colorFlow: StateFlow<Int?> = _colorFlow

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

    fun onClear() {
        scope.cancel()
    }
}