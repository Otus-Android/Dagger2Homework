package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.quilifiers.AppContext

class ReceiverViewModel @AssistedInject constructor(
    @AppContext private val context: Context,
    private val observableForFragments: ObservableForFragments,
    @Assisted private val onEventCallback: (color: Int) -> Unit,
) {
    private val scope = CoroutineScope(Dispatchers.Main)

    init {
        scope.launch {
            observableForFragments.mutableSharedFlow.collect {
                observeColors(it.color)
            }
        }
    }

    private fun observeColors(color: Int) {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        onEventCallback.invoke(color)
    }

    @AssistedFactory
    interface ReceiverViewModelFactory {
        fun create(@Assisted onEventCallback: (color: Int) -> Unit): ReceiverViewModel
    }
}