package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Provider

class ViewModelReceiver(
    private val context: Context,
    private val colorState: MutableStateFlow<Int>
) : ViewModel() {

    fun observeColors(): StateFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return colorState.asStateFlow()
    }

    class Factory @Inject constructor(
        @AppName private val context: Provider<Context>,
        private val colorState: Provider<MutableStateFlow<Int>>,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
                ViewModelReceiver(
                    context.get(),
                    colorState.get()
                ) as T
            } else {
                throw IllegalStateException("Unknown ViewModel class")
            }
        }
    }
}