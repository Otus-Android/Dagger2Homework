package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class ViewModelReceiver @Inject constructor(
    _colorFlow: MutableStateFlow<Color>,
    @ApplicationContextQualifier private val context: Context
) : ViewModel() {

    val colorFlow: StateFlow<Color> = _colorFlow

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}