package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.annotation.ApplicationContext
import ru.otus.daggerhomework.di.annotation.scope.FragmentReceiverScope
import javax.inject.Inject

@FragmentReceiverScope
class ViewModelReceiver @Inject constructor(
    private val colorReceiver: ColorReceiver,
    @ApplicationContext private val context: Context
) {

    private val viewModelReceiverScope = CoroutineScope(Dispatchers.Main)

    private val _colorEventFlow = MutableStateFlow<Int?>(null)

    init {
        observeColors()
    }

    val colorEventFlow = _colorEventFlow.asStateFlow()

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        colorReceiver.listenColorEvents()
            .filterNotNull()
            .onEach { color ->
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                _colorEventFlow.tryEmit(color)
            }.launchIn(viewModelReceiverScope)
    }

    fun onDestroyView() {
        viewModelReceiverScope.cancel()
    }
}