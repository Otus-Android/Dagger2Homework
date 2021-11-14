package ru.otus.daggerhomework.producer

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    val context: Activity,
    private val producerColor: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        viewModelScope.launch {
            producerColor.emit(color)
        }
        Toast.makeText(context, "Color sent: $color", Toast.LENGTH_LONG).show()
    }
}