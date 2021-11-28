package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val colorStateFlow: MutableStateFlow<Int>
) : ViewModel() {
    private val _color = MutableStateFlow<Int>(0)
    val color: StateFlow<Int> = _color

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        viewModelScope.launch {
            colorStateFlow.collect {
                _color.value = it
            }
        }
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}