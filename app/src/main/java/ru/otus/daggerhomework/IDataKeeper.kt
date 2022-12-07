package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject


@ActivityScope
interface IDataKeeper {

    suspend fun saveData(newData: Int)

    fun getFlow(): StateFlow<Int>
}

@ActivityScope
class DataKeeper @Inject constructor() : IDataKeeper {

    private val _colorData = MutableStateFlow<Int>(0)
    private val colorData: StateFlow<Int> = _colorData

    override suspend fun saveData(newData: Int) {
        _colorData.emit(newData)
    }

    override fun getFlow(): StateFlow<Int> {
        return colorData
    }

}