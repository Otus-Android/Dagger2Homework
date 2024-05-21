package ru.otus.daggerhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class AppObserver @Inject constructor() {
    private val _liveData = MutableLiveData<Int>()
    val liveData: LiveData<Int> = _liveData

    fun sendColor(color: Int) {
        _liveData.value = color
    }
}