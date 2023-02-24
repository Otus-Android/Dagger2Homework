package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

interface ColorRepository {
  fun getColorFlow(): Flow<Int>
  fun setColor(@ColorInt color: Int)
}

class ColorRepositoryImpl @Inject constructor(): ColorRepository {

  private val _stateFlow = MutableStateFlow(0)

  override fun getColorFlow(): Flow<Int> = _stateFlow.asStateFlow()

  override fun setColor(@ColorInt color: Int) {
    _stateFlow.value = color
  }
}