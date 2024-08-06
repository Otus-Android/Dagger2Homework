package ru.otus.daggerhomework.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorState: MutableStateFlow<Int>
)  : ViewModel() {

    private val _color = MutableStateFlow(0)
    val color: StateFlow<Int> = _color

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            colorState.collectLatest { _color.value = it }
        }
    }
}

class ViewModelReceiverFactory @Inject constructor(
    @AppContext private val context: Context,
    private val colorState: MutableStateFlow<Int>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelReceiver(context, colorState) as T
    }
}