package ru.otus.daggerhomework.receivers

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import ru.otus.daggerhomework.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val source: MutableStateFlow<Int>
) {
    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun observeColors(callback: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        scope.launch { source.collect { callback(it) }}
    }

    fun clear() {
        scope.cancel()
    }
}