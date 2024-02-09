package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class MyObserver @Inject constructor() {

    private val _data = MutableStateFlow(0)

    suspend fun send(data: Int) {
        _data.emit(data)
    }

    fun observe(): Flow<Int> {
        return _data.asStateFlow()
    }
}