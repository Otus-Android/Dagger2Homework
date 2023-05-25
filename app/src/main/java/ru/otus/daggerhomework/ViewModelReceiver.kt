package ru.otus.daggerhomework

import android.app.*
import android.content.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val flow: StateFlow<Int?>
) {

    private val _colorFlow: MutableStateFlow<Int?> = MutableStateFlow(null)
    val colorFlow: StateFlow<Int?> = _colorFlow
    private val scope = CoroutineScope(Dispatchers.Main + Job())

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст")

        scope.launch {
            flow.collect { color ->
                color?.let {
                    _colorFlow.value = it
                }
            }
        }
    }

    fun onCleared() {
        scope.cancel()
    }
}