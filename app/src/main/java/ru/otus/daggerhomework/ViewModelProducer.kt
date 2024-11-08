package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorEventProducer: MutableStateFlow<Int?>
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        colorEventProducer.value = colorGenerator.generateColor()

        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @ActivityContext private val context: Context,
        private val colorEventProducer: MutableStateFlow<Int?>
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ViewModelProducer(colorGenerator, context, colorEventProducer) as T
    }
}