package ru.otus.daggerhomework

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject


@ActivityScope
object MyObServer  {

    private val _data = MutableStateFlow(0)
    private val data = _data.asStateFlow()


    class Observe @Inject constructor() {
        fun observe(): Flow<Int> {
            return data
        }
    }

    class Send @Inject constructor() {
        suspend fun send(data: Int) {
            _data.emit(data)
        }
    }

}
