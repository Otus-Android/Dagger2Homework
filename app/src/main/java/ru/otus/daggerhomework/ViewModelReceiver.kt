package ru.otus.daggerhomework

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val stateFlow: MutableStateFlow<Int>
) : ViewModel() {

    companion object {
        private const val TAG = "ViewModelReceiver"
    }

    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int> = _color

    init {
        observeColors()
    }

    private fun observeColors() {
        Log.d(TAG, "Color received")
        viewModelScope.launch {
            stateFlow.collect {
                _color.postValue(it)
            }
        }
    }
}