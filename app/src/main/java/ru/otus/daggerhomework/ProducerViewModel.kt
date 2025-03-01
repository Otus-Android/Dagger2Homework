package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val observableForFragments: ObservableForFragments
) {
    private val scope = CoroutineScope(Dispatchers.Main)

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        scope.launch {
            observableForFragments.mutableSharedFlow.emit(Events.Event)
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}