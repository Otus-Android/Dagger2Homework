package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.colorexchanger.ColorUpdater
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorUpdater: ColorUpdater
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
        colorUpdater.update(colorGenerator.generateColor())
    }
}