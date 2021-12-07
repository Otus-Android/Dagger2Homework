package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    private val stateFlow: StateFlow<Int>
) : ViewModel() {

    fun observeColors(): StateFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return stateFlow
    }

    class ViewModelReceiverFactory @Inject constructor(
        @ApplicationContext
        private val context: Context,
        private val stateFlow: StateFlow<Int>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelReceiver(context, stateFlow) as T
        }
    }
}