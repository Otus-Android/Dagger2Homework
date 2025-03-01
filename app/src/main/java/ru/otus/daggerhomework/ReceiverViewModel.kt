package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class ReceiverViewModel @Inject constructor(
    private val context: Context,
    private val observableForFragments: ObservableForFragments
) {
    private val scope = CoroutineScope(Dispatchers.Main)

    init {
        scope.launch {
            observableForFragments.mutableSharedFlow.collect {
                observeColors()
            }
        }
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Application context is required")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}