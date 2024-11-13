package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context
) {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}