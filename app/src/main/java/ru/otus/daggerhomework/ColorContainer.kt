package ru.otus.daggerhomework

import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.collect
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

interface ColorContainer {
    fun setColor(color: Int)
    fun getData() : LiveData<Int>
}

@Singleton
class ColorContainerImpl @Inject constructor() : ColorContainer {
    private val _state : MutableStateFlow<Int> = MutableStateFlow(value = 0)
    val state : StateFlow<Int> = _state.asStateFlow()

    override fun setColor(color: Int) {
        _state.value = color
    }

    override fun getData() : LiveData<Int> {
        return state.asLiveData()
    }
}
