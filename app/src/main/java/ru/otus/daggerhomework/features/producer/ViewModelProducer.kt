package ru.otus.daggerhomework.features.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.utils.ColorChangeObserver
import ru.otus.daggerhomework.utils.ColorGenerator
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorChangeObserver: ColorChangeObserver,
    private val context: Context
) : CoroutineScope by MainScope() {

    fun generateAndSendColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        val color = colorGenerator.generateColor()
        launch { colorChangeObserver.changeColor(color) }
    }
}