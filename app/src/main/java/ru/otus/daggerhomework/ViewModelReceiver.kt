package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver(
    private val context: Context,
    private val observer: MutableStateFlow<Int>
) : ViewModel() {

    private val _events = MutableStateFlow(0)
    val events: StateFlow<Int> = _events

    init {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            observer.collect {
                _events.emit(it)
            }
        }
    }
}

class ReceiverViewModelFactory @Inject constructor(
    @ApplicationContext private val context: Context,
    private val observer: MutableStateFlow<Int>
) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ViewModelReceiver(context, observer) as T
}