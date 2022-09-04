package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver (
    private val context: Context,
    private val eventObserver: MutableStateFlow<Event>,
): ViewModel() {

    private val _color: MutableLiveData<Int> = MutableLiveData(Color.WHITE)
    val color: LiveData<Int> = _color

    init {
        viewModelScope.launch {
            eventObserver.collect { event ->
                when (event) {
                    is Event.ChangeColor -> {
                        observeColors(event.color)
                    }
                    Event.Initial -> null
                }
            }
        }
    }

    private fun observeColors(color: Int) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        _color.postValue(color)
        Log.e("ViewModelReceiver", "Color received")
        Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
    }
}

class ViewModelReceiverProviderFactory
@Inject constructor(
    @AppContext private val context: Context,
    @EventObserver private val eventObserver: MutableStateFlow<Event>,
)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java))
            return ViewModelReceiver(context, eventObserver) as T
        else throw IllegalArgumentException()
    }
}