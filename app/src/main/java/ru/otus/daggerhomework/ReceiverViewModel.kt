package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull

class ReceiverViewModel(
    private val context: Context,
    event: MutableStateFlow<Event?>
) {

    val event = event.mapNotNull { it }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}