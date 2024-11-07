package ru.otus.daggerhomework

import android.graphics.Color
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityScope

class MainActivityState(color: Int = Color.BLACK) {
    init {
        Log.e("TESTTEST", "MainActivityState create")
    }

    private val _colors = MutableStateFlow(color)
    val colors: StateFlow<Int>
        get() = _colors

    fun updateColor(color: Int) {
        CoroutineScope(Dispatchers.Main.immediate).launch {
            _colors.emit(color)
        }
    }
}