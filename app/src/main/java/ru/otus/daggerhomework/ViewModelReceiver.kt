package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.qualifiers.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    flow: StateFlow<Int>
) {

    val colorsFlow = flow
        .filter { it != 0 }
        .onEach { observeColors() }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}