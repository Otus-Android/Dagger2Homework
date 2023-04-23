package ru.otus.daggerhomework.viewmodel

import android.app.Activity
import android.content.Context
import android.widget.Toast
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.usecases.SetColorsUseCase
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext  private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val setColorsUseCase: SetColorsUseCase
) {

    fun generateColor() {
        if (context !is Activity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        val color = colorGenerator.generateColor()
        setColorsUseCase.invoke(color)
    }
}