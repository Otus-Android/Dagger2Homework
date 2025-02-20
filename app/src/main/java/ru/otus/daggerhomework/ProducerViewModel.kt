package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorState: ColorState
) {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        val color = colorGenerator.generateColor()
        colorState.setColor(color)
    }
}