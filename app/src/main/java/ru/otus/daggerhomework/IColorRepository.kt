package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject

interface IColorRepository : IColorRepositoryReadOnly, IColorRepositoryWriteOnly

interface IColorRepositoryReadOnly {
    val colorFlow: StateFlow<Color>
}

interface IColorRepositoryWriteOnly {
    fun updateColor(color: Color)
}

@ActivityScope
class ColorRepositoryImpl @Inject constructor() : IColorRepository {
    private val _colorFlow: MutableStateFlow<Color> = MutableStateFlow(Color.Unavailable)
    override val colorFlow: StateFlow<Color> = _colorFlow.asStateFlow()

    override fun updateColor(color: Color) {
        _colorFlow.update { color }
    }
}