package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val colorRepository: ColorRepository,
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        val color = colorGenerator.generateColor()
        colorRepository.setColor(color)
    }
}