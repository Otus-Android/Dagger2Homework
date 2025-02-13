package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast

class ProducerViewModel(
    private val colorGenerator: ColorGenerator,
    private val context: Context
) {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Activity context is required")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}