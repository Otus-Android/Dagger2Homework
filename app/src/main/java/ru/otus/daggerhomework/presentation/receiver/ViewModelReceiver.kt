package ru.otus.daggerhomework.presentation.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.utils.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver : ViewModel() {

    @Inject
    lateinit var state: StateFlow<Int>

    @Inject
    @ApplicationContext
    lateinit var context: Context

    fun observeColors(action: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        action.invoke(state.value)
    }
}