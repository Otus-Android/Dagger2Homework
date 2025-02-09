package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast

class ReceiverViewModel(
    private val context: Context
) {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}