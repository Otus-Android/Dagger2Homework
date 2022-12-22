package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

class ViewModelReceiver(
    private val context: Context,
    dataKeeper: IDataKeeper
) {
    private val _colorData = MutableStateFlow<Int>(0)
    val colorData: StateFlow<Int> = _colorData

    private val colorFlow = dataKeeper.getFlow()

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        colorFlow.collect { colorCode ->
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

            _colorData.emit(colorCode)
        }
    }
}