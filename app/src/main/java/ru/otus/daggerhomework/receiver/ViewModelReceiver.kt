package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val stateFlow: StateFlow<Int>
) {

    fun observeColors() : StateFlow<Int> {
        if (context !is Application) {
            throw RuntimeException("Здесь нужен контекст апликейшена")
        }
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return stateFlow
    }
}