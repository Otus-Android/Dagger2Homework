package ru.otus.daggerhomework.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.repository.ColorRepositoryImpl
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext  private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorRepositoryImpl: ColorRepositoryImpl
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        val color = colorGenerator.generateColor()
        colorRepositoryImpl.updateColor(color)
    }
}