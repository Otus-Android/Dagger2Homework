package ru.otus.daggerhomework.ui.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import ru.otus.daggerhomework.di.annotations.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context
) {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}