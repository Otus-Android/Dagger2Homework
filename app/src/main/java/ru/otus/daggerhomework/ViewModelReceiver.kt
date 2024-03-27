package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModelReceiver(
    private val observer: StateFlow<Int>,
    private val onReceive: (Int) -> Unit
): ViewModel() {

    fun observeColors(context: Context) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            observer.collect { color: Int ->
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                onReceive.invoke(color)
            }
        }
    }

    class Factory(
        private val observer: StateFlow<Int>,
        private val onReceive: (Int) -> Unit,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
                ViewModelReceiver(observer, onReceive) as T
            } else {
                throw IllegalArgumentException("ViewModelProvider.Factory error")
            }
        }
    }
}