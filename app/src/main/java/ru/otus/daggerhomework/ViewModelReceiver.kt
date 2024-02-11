package ru.otus.daggerhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver(
    private val stateObserver: StateObserver
) : ViewModel() {

    private val _colorLiveData = MutableLiveData<Int>()
    val colorLiveData: LiveData<Int> = _colorLiveData

    init {
        viewModelScope.launch {
            stateObserver.getStateObserver().collect {
                it?.let { color ->
                    _colorLiveData.value = color
                }
            }
        }
    }
}

class ViewModelReceiverFactory
@Inject
constructor(
    private val stateObserver: StateObserver
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ViewModelReceiver::class.java -> {
                ViewModelReceiver(stateObserver)
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class")
        } as T
    }
}
