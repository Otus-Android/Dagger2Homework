package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val observer: Observer
) {

    private val _colorState: MutableStateFlow<ColorState> = MutableStateFlow(ColorState.Init)
    val colorState: StateFlow<ColorState>
        get() = _colorState.asStateFlow()

    init {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        CoroutineScope(Dispatchers.Main).launch {
            observer.getEvents().consumeEach {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                _colorState.value = ColorState.ColorReceived(it)
            }
        }
    }

    sealed interface ColorState {
        object Init : ColorState
        data class ColorReceived(val color: Int) : ColorState
    }
}