package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val mainActivityState: MainActivityState
) {
    val colors: StateFlow<Int>
        get() = mainActivityState.colors
}