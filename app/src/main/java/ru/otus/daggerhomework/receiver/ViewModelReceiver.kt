package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    @Named("ApplicationContext")
    private val context: Context,
    val colorsFlow: Flow<Int>
) : ViewModel() {

    init {
        viewModelScope.launch {
            colorsFlow.collect {
                observeColors()
            }
        }
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}