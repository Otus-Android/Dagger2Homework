package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.qualifiers.AppContext
import ru.otus.daggerhomework.di.qualifiers.Immutable
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @Immutable private val stateFLow: StateFlow<Int>,
    @AppContext private val context: Context
) {

    fun observeColors(): StateFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return stateFLow
    }
}