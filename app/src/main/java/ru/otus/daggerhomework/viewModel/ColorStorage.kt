package ru.otus.daggerhomework.viewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface ColorStorage {
    fun getColorFlow(): MutableStateFlow<Int?>
}

class ColorStorageImpl @Inject constructor() : ColorStorage {

    private val colorFlow = MutableStateFlow<Int?>(null)

    override fun getColorFlow(): MutableStateFlow<Int?> {
        return colorFlow
    }
}

interface ColorObserver {
    suspend fun getColorFlow(): StateFlow<Int?>
}

class ColorObserverImpl @Inject constructor(
    private val colorManager: ColorStorage
) : ColorObserver {

    override suspend fun getColorFlow(): StateFlow<Int?> {
        return colorManager.getColorFlow()
    }

}

interface ColorEmitter {
    suspend fun sendColor(color: Int)
}

class ColorEmitterImpl @Inject constructor(
    private val colorManager: ColorStorage
) : ColorEmitter {
    override suspend fun sendColor(color: Int) {
        colorManager.getColorFlow().value = color
    }
}