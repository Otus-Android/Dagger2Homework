package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ColorsDataStore @Inject constructor() : ColorsDataStoreMutable, ColorsDataStoreUnmutable {
    private val _colorFlow = MutableSharedFlow<Int>()
    override val colorFlow = _colorFlow.asSharedFlow()

    override suspend fun sent(color: Int) {
        _colorFlow.emit(color)
    }
}

interface ColorsDataStoreMutable {
    val colorFlow: SharedFlow<Int>
    suspend fun sent(color: Int)
}

interface ColorsDataStoreUnmutable {
    val colorFlow: SharedFlow<Int>
}