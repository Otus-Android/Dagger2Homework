package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer constructor (
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val state: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent ${colorGenerator.generateColor()}",
            Toast.LENGTH_LONG).show()
        state.value = colorGenerator.generateColor()
    }
}
class ProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext  private val context: Context,
    val state: MutableStateFlow<Int>): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelProducer(colorGenerator, context, state) as T
    }
}