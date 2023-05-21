package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val stateFlow: MutableStateFlow<Int>
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            stateFlow.value = colorGenerator.generateColor()
        }
    }
}