package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelProducer (
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorEventObserver: ColorEventObserver
): ViewModel() {

    private fun generateColor(): Int {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        return colorGenerator.generateColor()
    }

    fun sendEvent() {
        colorEventObserver.setColor(color = generateColor())
    }
}


class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorEventObserver: ColorEventObserver
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
            return ViewModelProducer(
                colorGenerator = colorGenerator,
                context = context,
                colorEventObserver = colorEventObserver
            ) as T
        } else throw IllegalArgumentException()
    }
}