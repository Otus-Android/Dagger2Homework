package ru.otus.daggerhomework.presentation

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val colorObserver: ColorObserver
) {

    private val scope = CoroutineScope(Dispatchers.Main)

    fun observeColors(onColorReceived: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        scope.launch {
            colorObserver.colorFlow.collect { color ->
                onColorReceived(color)
            }
        }
    }
}