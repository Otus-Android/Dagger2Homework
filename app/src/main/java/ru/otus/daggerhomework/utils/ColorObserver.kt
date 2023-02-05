package ru.otus.daggerhomework.utils

import androidx.annotation.ColorInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ColorProducer {
    val color: MutableLiveData<Int>
}

interface ColorConsumer {
    @ColorInt
    fun getColorInt(): LiveData<Int>
}

class ColorObserver : ColorProducer, ColorConsumer {

    override val color: MutableLiveData<Int> = MutableLiveData(0)

    override fun getColorInt(): LiveData<Int> = color
}
