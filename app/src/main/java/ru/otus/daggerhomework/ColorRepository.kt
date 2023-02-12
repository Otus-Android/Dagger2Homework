package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

interface ColorRepository {
    fun getColorLiveData(): LiveData<Int>
    fun setColor(@ColorInt color: Int)
}

@ActivityScope
class ColorRepositoryImpl @Inject constructor() : ColorRepository {

    private val colorLiveData = MutableLiveData(0)

    override fun getColorLiveData(): LiveData<Int> {
        return colorLiveData
    }

    override fun setColor(color: Int) {
        colorLiveData.value = color
    }

}