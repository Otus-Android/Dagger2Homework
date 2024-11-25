package com.mironchik.multimodule.base.colors

import kotlinx.coroutines.flow.StateFlow

interface ColorsController {
    val color: StateFlow<Int>
    fun updateColor(color: Int)
}