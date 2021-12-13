package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver(
    private val colorState: MutableStateFlow<Int>,
    private val context: Context
) : ViewModel() {

    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int> get() = _color

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            colorState.collect { colorInt ->
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                _color.postValue(colorInt)
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class ViewModelReceiverFactory @Inject constructor(
        private val colorState: MutableStateFlow<Int>,
        @Named(APPLICATION_CONTEXT) private val context: Context
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ViewModelReceiver(colorState, context) as T
        }
    }
}