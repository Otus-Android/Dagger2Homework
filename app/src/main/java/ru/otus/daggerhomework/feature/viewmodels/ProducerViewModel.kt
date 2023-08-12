package ru.otus.daggerhomework.feature.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.feature.models.ColorGenerator

class ProducerViewModel(
    private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorUpdater: MutableStateFlow<Int?>
) {

    fun onButtonClick() {
        colorUpdater.tryEmit(colorGenerator.generateColor())
        onColorGenerated()
    }

    private fun onColorGenerated() {
        if (context !is FragmentActivity) {
            throw RuntimeException("Здесь нужен контекст активити")
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}