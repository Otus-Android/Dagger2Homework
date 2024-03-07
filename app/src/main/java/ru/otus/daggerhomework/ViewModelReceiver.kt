package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ViewModelReceiver(
    private val context: Context,
    subject: PublishSubject<Int>
) : ViewModel() {
    private val _colorFlow = MutableSharedFlow<Int>()

    val colorFlow = _colorFlow.asSharedFlow()

    init {
        subject.subscribe {
            viewModelScope.launch {
                observeColors(it)
            }
        }
    }

    private suspend fun observeColors(color: Int) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        _colorFlow.emit(color)
    }
}