package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    val eventsReader: EventsReader
):ViewModel() {
    init {
        viewModelScope.launch {
            eventsReader.eventsFlow.collect {
                observeColors()
            }
        }
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}