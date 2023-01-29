package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton


interface GetColorValue {
    suspend fun getValue(): MutableStateFlow<Int>
}

interface SetColorValue {
    suspend fun setValue(value: Int)
}

@Singleton
class ColorStateColorValueImpl @Inject constructor() : SetColorValue, GetColorValue {

    private val colorValue: MutableStateFlow<Int> = MutableStateFlow(0)

    override suspend fun setValue(value: Int) {
        colorValue.emit(value)
    }

    override suspend fun getValue(): MutableStateFlow<Int> {
        return colorValue
    }
}