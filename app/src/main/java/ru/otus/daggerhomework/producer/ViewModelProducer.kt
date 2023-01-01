package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.ActivityContext
import ru.otus.daggerhomework.ColorSharedViewModel
import ru.otus.daggerhomework.utils.ColorGenerator
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorSharedViewModel: ColorSharedViewModel,
    @ActivityContext private val context: Context
) {

    fun generateColor() {
        val color = colorGenerator.generateColor()
        colorSharedViewModel.setColor(color)
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}