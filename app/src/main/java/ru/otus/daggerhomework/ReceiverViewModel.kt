package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val stateContainer: StateContainer
) {

    fun observeColors(): StateFlow<Int> {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return stateContainer.getState()
    }
}