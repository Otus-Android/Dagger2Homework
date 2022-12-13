package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val colorsFlow: MutableSharedFlow<Int>,
    private val colorGenerator: ColorGenerator,
    @Named("ActivityContext")
    private val context: Context,
) : ViewModel() {

    fun generateColor() {
        val color = colorGenerator.generateColor()
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent $color", Toast.LENGTH_LONG).show()
        colorsFlow.tryEmit(color)
    }

}