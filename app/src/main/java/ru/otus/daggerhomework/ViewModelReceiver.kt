package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.Constants.APP_CONTEXT
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    private val flow: StateFlow<Int?>,
    @Named(APP_CONTEXT)
    private val context: Context
) {

    private val _colorFlow: MutableStateFlow<Int?> = MutableStateFlow(null)
    val colorFlow: StateFlow<Int?> = _colorFlow

    private val receiverScope = CoroutineScope(Dispatchers.Main + Job())

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        receiverScope.launch {
            flow.collect { color ->
                _colorFlow.value = color
                color?.let {
                    Toast.makeText(context, String.format("Color received %s", it), Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
