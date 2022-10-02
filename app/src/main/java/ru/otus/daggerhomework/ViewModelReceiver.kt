package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ViewModelReceiver
@Inject constructor(
    @AppContext private val context: Context,
    @EventObserverReceiver private val eventObserveReceiver: @JvmSuppressWildcards StateFlow<Event>,
) {

    private val viewModelReceiverScope = ViewModelReceiverScope()

    private val _color: MutableLiveData<Int> = MutableLiveData(Color.WHITE)
    val color: LiveData<Int> = _color

    init {
        viewModelReceiverScope.launch {
            eventObserveReceiver.collect { event ->
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

    fun cancelRunCoroutine() {
        viewModelReceiverScope.cancel()
    }
}

class ViewModelReceiverScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main + CoroutineName("ViewModelReceiverScope")
}