package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.RuntimeException
import java.lang.ref.WeakReference
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ru.otus.daggerhomework.Application private val context: WeakReference<Context>,
    private val flow: StateFlow<Int>
) : ViewModel() {
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow: SharedFlow<Int> = _sharedFlow
    init {
        observeColors()
    }
    private fun observeColors() {
        if (context.get() !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            flow.filter { it != 0 }
                .collect {
                _sharedFlow.emit(it)
            }
        }
        Toast.makeText(context.get(), "Color received", Toast.LENGTH_LONG).show()
    }
}