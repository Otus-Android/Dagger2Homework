package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

interface ColorRepository : ColorRepositoryReadOnly, ColorRepositoryWriteOnly

interface ColorRepositoryReadOnly {
    val colorFlow: StateFlow<GeneratedColor>
}

interface ColorRepositoryWriteOnly {
    fun updateColor(color: GeneratedColor)
}

@ActivityScope
class ColorRepositoryImpl @Inject constructor() : ColorRepository {
    private val _colorFlow: MutableStateFlow<GeneratedColor> = MutableStateFlow(GeneratedColor.Default)
    override val colorFlow: StateFlow<GeneratedColor> = _colorFlow.asStateFlow()

    override fun updateColor(color: GeneratedColor) {
        _colorFlow.update { color }
    }
}