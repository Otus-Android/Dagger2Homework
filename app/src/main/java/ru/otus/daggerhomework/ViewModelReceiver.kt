package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Provider

class ViewModelReceiver @AssistedInject constructor(
    @ApplicationContext private val contextProvider: Provider<Context>,
    private val eventFlow: SharedFlow<AppEvent>
) : ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(): ViewModelReceiver
    }
    init {
        viewModelScope.launch {
            eventFlow.collect {
                observeColors()
            }
        }
    }

    val colorState: StateFlow<Int?> = eventFlow.map { it.color }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun observeColors() {
        val context = contextProvider.get()
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
    }
}