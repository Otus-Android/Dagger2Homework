package ru.otus.daggerhomework.presentation.viewmodels

import android.app.Application
import android.content.Context
import android.widget.Toast
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ReceiverViewModel @Inject constructor (
   @AppContext private val context: Context
) {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}