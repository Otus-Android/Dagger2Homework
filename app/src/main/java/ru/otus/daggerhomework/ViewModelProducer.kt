package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorEventObserver: ColorEventObserver
) {

    private fun generateColor(): Int {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        return colorGenerator.generateColor()
    }

    fun sendEvent() {
        colorEventObserver.setColor(color = generateColor())
    }
}