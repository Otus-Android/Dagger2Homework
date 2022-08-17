package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorStateFlow: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val currentColor = colorGenerator.generateColor()
        viewModelScope.launch {
            colorStateFlow.emit(currentColor)
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}