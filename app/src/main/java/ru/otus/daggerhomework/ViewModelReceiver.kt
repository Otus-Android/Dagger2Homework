package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver(
    private val subscriber: Flow<Color>,
    private val context: Context
) : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    fun observeColors(onNewColor: (Color) -> Unit) {
        viewModelScope.launch {
            subscriber.collect { color ->
                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received: $color", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun factory(
            subscriber: Flow<Color>,
            context: Context
        ) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModelReceiver(subscriber, context) as T
            }
        }
    }
}