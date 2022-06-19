package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.application.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    private val colorState: MutableStateFlow<Int?>
) : ViewModel() {

    fun observeColors(): StateFlow<Int?> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorState
    }

    class Factory @Inject constructor(
        @ApplicationContext private val context: Context,
        private val colorState: MutableStateFlow<Int?>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ViewModelReceiver(context, colorState) as T
        }
    }
}