package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.annotations.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext
    private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorObserver: ColorObserver
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorObserver.sendColor(colorGenerator.generateColor())
    }
}