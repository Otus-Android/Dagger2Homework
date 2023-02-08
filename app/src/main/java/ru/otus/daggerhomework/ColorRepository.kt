package ru.otus.daggerhomework

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@PerMainActivity
class ColorRepository @Inject constructor() {

  private val _stateFlow = MutableStateFlow(0)
  val stateFlow = _stateFlow.asStateFlow()

  fun setColor(color: Int) {
    _stateFlow.value = color
  }
}