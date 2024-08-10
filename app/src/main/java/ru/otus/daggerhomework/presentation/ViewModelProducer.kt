package ru.otus.daggerhomework.presentation

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val colorObserver: ColorObserver
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorObserver.setColor(colorGenerator.generateColor())
    }
}