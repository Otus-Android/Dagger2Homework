package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

interface ColorReceiver {
    fun getColorLiveData(): LiveData<Int>
}

interface ColorProducer {
    fun setColor(@ColorInt color: Int)
}

@ActivityScope
class ColorRepositoryImpl @Inject constructor() : ColorReceiver, ColorProducer {

    private val colorLiveData = MutableLiveData(0)

    override fun getColorLiveData(): LiveData<Int> {
        return colorLiveData
    }

    override fun setColor(color: Int) {
        colorLiveData.value = color
    }

}