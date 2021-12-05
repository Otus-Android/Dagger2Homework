package ru.otus.daggerhomework.viewmodels

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import ru.otus.daggerhomework.EventBus
import ru.otus.daggerhomework.di.ApplicationContext
import java.lang.RuntimeException

class ViewModelReceiver(
    private val context: Context,
    receiver: EventBus
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
        private val observer: EventBus
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass == ViewModelReceiver::class.java) {
                return ViewModelReceiver(context, observer) as T
            }

            throw IllegalStateException("Unknown class ${modelClass.name}")
        }
    }
}