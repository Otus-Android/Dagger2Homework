package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    colorsDataStore: ColorsDataStore,
) : ViewModel() {

    private val _colorFlow = MutableSharedFlow<Int>()
    val colorFlow = _colorFlow.asSharedFlow()

    init {
        colorsDataStore.colorFlow.onEach {
                observeColors(it)
            }.launchIn(viewModelScope)
    }

    suspend fun observeColors(color: Int) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        _colorFlow.emit(color)
    }
}

open class ViewModelReceiverFactory @Inject constructor(
    @ApplicationContext private val context: Context,
    private val colorsDataStore: ColorsDataStore,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java))
            return ViewModelReceiver(
                context,
                colorsDataStore,
            ) as T
        else throw IllegalArgumentException()
    }
}