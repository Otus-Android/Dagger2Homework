package ru.otus.daggerhomework.presentation.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.util.EventFlow
import ru.otus.daggerhomework.util.IntEvent

class ViewModelReceiver @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    @AppContext val context: Context,
    val eventFlow: EventFlow
) : ViewModel() {

    private val _colorFlow = MutableStateFlow(0)
    val colorFlow = _colorFlow.asStateFlow()

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        eventFlow.events().collect {
            when (it) {
                is IntEvent -> {
                    _colorFlow.value = it.value
                    Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @AssistedFactory
    interface Factory {

        fun create(savedStateHandle: SavedStateHandle): ViewModelReceiver
    }
}
