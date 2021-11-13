package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver(
    val observer: Channel<Result>,
    private val context: Context
) : ViewModel() {

    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int>
        get() = _color

    fun observeColors() {
        viewModelScope.launch {
            if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
            ensureActive()
            for (color in observer) {
                ensureActive()
                when (color) {
                    is Result.Success -> {
                        _color.value = color.color
                        Toast.makeText(context, "Color received: $color", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    class Factory @Inject constructor(
        private val observer: Channel<Result>,
        @ApplicationContext
        private val context: Context
    ) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelReceiver(observer, context) as T
        }
    }
}
