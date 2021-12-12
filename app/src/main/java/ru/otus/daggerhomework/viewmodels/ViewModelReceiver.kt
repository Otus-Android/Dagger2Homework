package ru.otus.daggerhomework.viewmodels

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import ru.otus.daggerhomework.EventBusReceiver

class ViewModelReceiver(
    private val context: Context,
    receiver: EventBusReceiver
) : ViewModel() {

    val colorFlow = receiver.events
        .onEach {
            observeColors(it)
        }.stateIn(viewModelScope, SharingStarted.Eagerly, 0)

    private fun observeColors(@ColorInt color: Int) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received $color", Toast.LENGTH_SHORT).show()
    }

    class Factory(
        private val context: Context,
        private val receiver: EventBusReceiver
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == ViewModelReceiver::class.java) {
                return ViewModelReceiver(context, receiver) as T
            }

            throw IllegalStateException("Unknown class ${modelClass.name}")
        }
    }
}