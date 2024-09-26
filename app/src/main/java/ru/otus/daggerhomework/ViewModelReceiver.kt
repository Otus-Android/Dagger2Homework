package ru.otus.daggerhomework

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    eventBus: EventBus
) : ViewModel() {

    val colorObserver = MutableStateFlow<Int>(0)

    init {
        viewModelScope.launch {
            eventBus.events.stateIn(viewModelScope).collect {
                Log.d("VM", "collect $it")
                colorObserver.emit(it)
            }
        }
    }

    class Factory @Inject constructor(
        private val eventBus: EventBus
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            Log.d("FACTORY", "eventBus $eventBus")
            return if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
                ViewModelReceiver(eventBus) as T
            } else {
                throw IllegalStateException("Unknown ViewModel class")
            }
        }
    }
}