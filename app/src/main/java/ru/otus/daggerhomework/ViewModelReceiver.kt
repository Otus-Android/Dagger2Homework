package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
class ViewModelReceiver(
    private val eventObserver: EventObserver,
    private val context: Context
) : ViewModel() {
    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        return eventObserver.getEvents().filterNotNull().onEach {
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        }
    }

    @Suppress("UNCHECKED_CAST")
    @ReceiverScope
    class ViewModelFactory @Inject constructor(
        private val eventObserver: EventObserver,
        @ApplicationContext private val context: Context
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelReceiver(eventObserver, context) as T
        }
    }
}