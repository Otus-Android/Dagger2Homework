package ru.otus.daggerhomework.di.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorState
import ru.otus.daggerhomework.di.activity.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorState: ColorState,
    @ActivityContext private val context: Context,
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        colorState.setColor(color)
        Toast.makeText(context, "Color sent $color", Toast.LENGTH_LONG).show()
    }
}