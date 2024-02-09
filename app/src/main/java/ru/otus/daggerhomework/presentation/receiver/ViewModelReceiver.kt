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
import ru.otus.daggerhomework.util.IntEvent
import ru.otus.daggerhomework.util.EventFlow
import java.lang.ref.WeakReference

class ViewModelReceiver @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    @Assisted context: Context,
    val eventFlow: EventFlow
) : ViewModel() {

    private val _colorFlow = MutableStateFlow(0)
    val colorFlow = _colorFlow.asStateFlow()

    private var contextReference: WeakReference<Context> = WeakReference(context)

    fun updateContext(context: Context) {
        contextReference = WeakReference(context)
    }

    suspend fun observeColors() {
        contextReference.get()?.let { context ->
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
    }

    @AssistedFactory
    interface Factory {

        fun create(savedStateHandle: SavedStateHandle, context: Context): ViewModelReceiver
    }
}
