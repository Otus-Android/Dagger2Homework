package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.activity.Event

class ViewModelReceiver(
    private val context: Context,
    private val stateEvent: StateFlow<Event>
) {

    fun observeColors() {
        if (context !is Application) {
            throw RuntimeException("Здесь нужен контекст апликейшена")
        }
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}