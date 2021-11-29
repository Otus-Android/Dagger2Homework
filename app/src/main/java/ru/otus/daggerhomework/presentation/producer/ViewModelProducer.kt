package ru.otus.daggerhomework.presentation.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.utils.ColorGeneratorImpl
import javax.inject.Inject

class ViewModelProducer(
    private val state: MutableStateFlow<Int>,
    private val colorGenerator: ColorGeneratorImpl,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        state.value = colorGenerator.generateColor()
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val state: MutableStateFlow<Int>,
    private val colorGenerator: ColorGeneratorImpl,
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelProducer(state, colorGenerator, context) as T
    }
}