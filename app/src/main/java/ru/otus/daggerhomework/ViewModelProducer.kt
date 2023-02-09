package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    @Named("ActivityContext") private val context: Context,
    private val stateChanel:MutableStateFlow<Int>
):ViewModel() {

    fun generateColor() {
        val color = colorGenerator.generateColor()
        stateChanel.value = color
        if (context !is MainActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color $color sent", Toast.LENGTH_LONG).show()
    }
}

