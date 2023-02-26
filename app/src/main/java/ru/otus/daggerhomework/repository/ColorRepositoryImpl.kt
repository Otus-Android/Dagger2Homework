package ru.otus.daggerhomework.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.otus.daggerhomework.di.PerActivity
import javax.inject.Inject


@PerActivity
class ColorRepositoryImpl @Inject constructor(): ColorRepository {
    private val _color = MutableStateFlow(0)

    override fun getColorFlow(): StateFlow<Int> = _color.asStateFlow()

    override fun updateColor(color: Int) {
        _color.value = color
    }
}