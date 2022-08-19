package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

interface ColorObserver {

    val colorFlow: StateFlow<Int>

    fun updateColor(@ColorInt colorInt: Int)

    @MainActivityScope
    class Base @Inject constructor() : ColorObserver {

        private val _colorFlow = MutableStateFlow(INIT_COLOR)
        override val colorFlow: StateFlow<Int>
            get() = _colorFlow

        override fun updateColor(@ColorInt colorInt: Int) {
            _colorFlow.value = colorInt
            println("ColorObserver $this")
        }

        companion object {

            private const val INIT_COLOR = 0
        }
    }
}

