package ru.otus.daggerhomework.presentation.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.utils.ColorGeneratorImpl
import javax.inject.Inject

class ViewModelProducer : ViewModel() {

    @Inject
    lateinit var state: MutableStateFlow<Int>

    @Inject
    lateinit var colorGenerator: ColorGeneratorImpl

    @Inject
    lateinit var context: Context

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        state.value = colorGenerator.generateColor()
    }
}