package ru.otus.daggerhomework.fragments.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.fragments.BaseViewModel
import ru.otus.daggerhomework.utils.ColorGenerator
import ru.otus.daggerhomework.utils.ColorProducer
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorProducer: ColorProducer
) : BaseViewModel {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        colorProducer.color.value = colorGenerator.generateColor()
    }
}
