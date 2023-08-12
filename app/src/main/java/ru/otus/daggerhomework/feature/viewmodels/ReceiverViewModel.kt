package ru.otus.daggerhomework.feature.viewmodels

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow

class ReceiverViewModel(
    private val context: Context,
    val stateColor: StateFlow<Int?>
) {

    fun onColorPopulate() {
        if (context !is Application) {
            throw RuntimeException("Здесь нужен контекст апликейшена")
        }
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}