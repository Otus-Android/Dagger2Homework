package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    private val channel: MutableSharedFlow<Int>,
    @Named("appContext") private val context: Context
)  : ViewModel() {
    private val _color = MutableStateFlow(0)
    val color: StateFlow<Int> = _color

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            channel.collect { color -> _color.value = color}
        }
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}