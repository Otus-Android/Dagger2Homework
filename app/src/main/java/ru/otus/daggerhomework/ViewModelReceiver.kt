package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver(
    @AppContext private val context: Context,
    private val eventFlow: MutableStateFlow<Int>
) : ViewModel() {
    private val _color = MutableStateFlow(0)
    val color: StateFlow<Int> = _color

    init {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            eventFlow.collectLatest { _color.value = it }
        }
    }
}

class ViewModelReceiverFactory @Inject constructor(
    @AppContext private val context: Context,
    private val eventFlow: MutableStateFlow<Int>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelReceiver(context, eventFlow) as T
    }
}