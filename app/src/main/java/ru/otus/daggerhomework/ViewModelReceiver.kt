package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext

class ViewModelReceiver(
    private val flowObserver: FlowObserver<Int>,
    @AppContext private val context: Context
) : ViewModel() {

    private val colorFlow = MutableSharedFlow<Int>()
    val color: Flow<Int> = colorFlow

    init {
        observeColors()
    }

    private fun observeColors() {
        viewModelScope.launch {
            flowObserver.valueFlow.collect {
                colorFlow.emit(it)

                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
