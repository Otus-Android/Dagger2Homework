package ru.otus.daggerhomework.viewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface ColorObserver {

    suspend fun sendColor(color: Int)

    suspend fun getColorFlow(): StateFlow<Int?>

}


class ColorObserverImpl @Inject constructor() : ColorObserver {

    private val colorFlow = MutableStateFlow<Int?>(null)

    override suspend fun sendColor(color: Int) {
        colorFlow.emit(color)
    }

    override suspend fun getColorFlow(): StateFlow<Int?> {
        return colorFlow
    }

}