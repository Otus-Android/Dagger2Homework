package ru.otus.daggerhomework

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor() : ViewModel() {

    private val _catsStateFlow = MutableStateFlow<Int>(-1)
    val catsStateFlow: StateFlow<Int> = _catsStateFlow

    fun sendEvent(color: Int){
        viewModelScope.launch(){
            _catsStateFlow.value = color
        }
    }
}

class MyViewModelFactory @Inject constructor() :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MyViewModel() as T
}