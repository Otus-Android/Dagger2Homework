package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val colorObserver: ColorObserver,
    @ApplicationContext private val context: Context
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private val _color = MutableStateFlow<Int?>(null)
    val color = _color.asStateFlow()

    init {
        scope.launch {
            colorObserver.currentColor.collectLatest { newColor ->
                _color.value = newColor
                observeColors()
            }
        }
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}