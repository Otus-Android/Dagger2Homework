package ru.otus.daggerhomework.ui.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.annotations.ActivityContext
import ru.otus.daggerhomework.utils.ColorGenerator
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}