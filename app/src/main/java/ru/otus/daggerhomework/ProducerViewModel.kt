package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow

class ProducerViewModel (
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val event: MutableStateFlow<Event?>
) {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        event.value = Event.PopulateColor(color = colorGenerator.generateColor())
    }
}