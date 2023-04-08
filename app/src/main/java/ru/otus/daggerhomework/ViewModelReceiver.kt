package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    colorProducer: ColorProducer
) {
    val colorState = colorProducer.color.onEach {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}