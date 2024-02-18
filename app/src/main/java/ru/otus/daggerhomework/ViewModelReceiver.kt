package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.colorexchanger.ColorListener
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    colorListener: ColorListener
) {

    private val scope = CoroutineScope(Dispatchers.Main)

    val colorFlow = colorListener.getColorFlow()

    init {
        observeColors()
    }

    private fun observeColors() {
        scope.launch {
            colorFlow.filterNotNull().collect {
                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun clear() {
        scope.cancel()
    }
}