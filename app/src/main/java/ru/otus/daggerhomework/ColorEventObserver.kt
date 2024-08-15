package ru.otus.daggerhomework

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ColorEventObserver @Inject constructor() {

    private val _colorEventState: MutableLiveData<Int> = MutableLiveData(Color.YELLOW)
    val colorEventState: LiveData<Int> = _colorEventState

    fun setColor(color: Int) {
        _colorEventState.value = color
    }

//    suspend fun onChangeColorState(onChange: (Int) -> Unit) {
//        colorEventState.collect {
//            onChange.invoke(it)
//        }
//
//    }
}