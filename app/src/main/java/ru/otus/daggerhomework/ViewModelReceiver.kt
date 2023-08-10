package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    innerColorStateFlow: StateFlow<Int?>
) {

    val colorStateFlow = innerColorStateFlow
        .filterNotNull()
        .onEach { observeColors() }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}