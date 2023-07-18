package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.SavedStateHandle
import dagger.assisted.AssistedFactory
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Provider

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val eventFlow: SharedFlow<AppEvent>
) {
    private val receiverScope = MainScope() + CoroutineName("ViewModelReceiverScope")

    init {
        receiverScope.launch {
            eventFlow.collect {
                observeColors()
            }
        }
    }

    val colorState: StateFlow<Int?> = eventFlow
        .map { it.color }
        .stateIn(
            receiverScope,
            SharingStarted.WhileSubscribed(5000),
            null,
        )

    fun observeColors() {
        val context = context
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
    }

    fun clear() {
        receiverScope.cancel()
    }
}