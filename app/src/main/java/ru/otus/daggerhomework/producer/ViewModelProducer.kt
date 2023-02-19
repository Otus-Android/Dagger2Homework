package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.components.DataModule
import ru.otus.daggerhomework.components.State
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorFlow: MutableSharedFlow<Int>,
    private val stateFlow: MutableStateFlow<State>
) : ViewModel(){
    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    init {
        viewModelScope.launch {
            stateFlow.collect{
                _state.value = it
            }
        }
    }

    fun generateColor() {
        sendColor()
    }
    private fun sendColor(){
        viewModelScope.launch {
            colorFlow.tryEmit(colorGenerator.generateColor())
        }
    }
}