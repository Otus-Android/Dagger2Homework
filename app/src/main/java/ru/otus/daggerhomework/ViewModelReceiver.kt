package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

@SuppressLint("StaticFieldLeak")
class ViewModelReceiver @Inject constructor(
    private val channel: MutableSharedFlow<Int>,
    @Named("applicationContext") private val context: Context
) : ViewModel() {

    private val _color = MutableStateFlow(0)
    val color: StateFlow<Int> = _color

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            channel.collect { color -> _color.value = color }
        }
    }
}