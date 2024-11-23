package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityComponent
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class ViewModelProducer @Inject constructor(
    private val mainActivityState: MainActivityState,
    private val colorGenerator: ColorGenerator,
): ViewModel() {
    fun generateColor() {
        mainActivityState.updateColor(colorGenerator.generateColor())
    }
}