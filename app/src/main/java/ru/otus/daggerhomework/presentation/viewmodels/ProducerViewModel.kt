package ru.otus.daggerhomework.presentation.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.domain.ColorGenerator
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context
) {

    fun generateColor():Int {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        return colorGenerator.generateColor()
    }
}