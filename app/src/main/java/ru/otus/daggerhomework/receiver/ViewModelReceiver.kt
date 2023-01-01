package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import ru.otus.daggerhomework.AppContext
import ru.otus.daggerhomework.ColorSharedViewModel
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorSharedViewModel: ColorSharedViewModel
) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val colorStateFlow = MutableStateFlow<Int?>(null)
    val colorObservable = colorStateFlow.asStateFlow()

    init {
        observeColors()
    }

    private fun observeColors() {
        scope.launch {
            colorSharedViewModel.getColor().collectLatest {
                colorStateFlow.value = it
                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun cancelScope() {
        scope.cancel()
    }
}