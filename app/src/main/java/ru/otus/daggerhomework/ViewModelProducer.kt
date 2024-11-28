package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

class ViewModelProducer @Inject constructor (
    private val colorGenerator: ColorGenerator,
    private val colorContainer: ColorContainer,
    private val context: Context
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст фрагмента")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorContainer.setColor(colorGenerator.generateColor())
    }
}