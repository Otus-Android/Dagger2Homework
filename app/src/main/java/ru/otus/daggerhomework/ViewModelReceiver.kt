package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Provider

class ViewModelReceiver @AssistedInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    @ApplicationContext private val contextProvider: Provider<Context>,
    private val eventFlow: SharedFlow<AppEvent>
) : ViewModel() {
    companion object {
        private const val KEY_COLOR_STATE = "COLOR_STATE"
    }

    @AssistedFactory
    interface Factory {
        fun create(savedStateHandle: SavedStateHandle): ViewModelReceiver
    }

    init {
        viewModelScope.launch {
            eventFlow.collect {
                observeColors()
            }
        }
    }

    val colorState: StateFlow<Int?> = eventFlow
        .map { it.color }
        .onEach { color -> savedStateHandle[KEY_COLOR_STATE] = color }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            savedStateHandle[KEY_COLOR_STATE],
        )

    fun observeColors() {
        val context = contextProvider.get()
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
    }
}