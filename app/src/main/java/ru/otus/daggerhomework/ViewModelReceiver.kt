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
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorObserver: StateFlow<Int>
) {

    fun init() {
        observeColors()
    }

    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    private val _colorState: MutableStateFlow<Int> = MutableStateFlow(R.color.teal_200)
    val colorState = _colorState.asStateFlow()

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        viewModelScope.launch {
            colorObserver.collect{
                _colorState.value = it
                Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun cancel(){
        viewModelScope.cancel()
    }
}