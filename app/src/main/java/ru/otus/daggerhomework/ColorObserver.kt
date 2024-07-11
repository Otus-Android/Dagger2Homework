package ru.otus.daggerhomework

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class ColorObserver @Inject constructor() {
    private val _color = MutableLiveData<Int>()
    val color: LiveData<Int> = _color

    fun postColor(color: Int) {
        _color.postValue(color)
    }
}