package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.components.DataModule
import ru.otus.daggerhomework.components.State
import ru.otus.daggerhomework.components.Success
import java.lang.String
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    private val colorFlow: SharedFlow<Int>,
    private val stateFlow: MutableSharedFlow<State>
) : ViewModel() {
    private val _colorFlow = MutableSharedFlow<Int>(replay = 1)
    val mColorFlow: SharedFlow<Int> = _colorFlow

    init {
        viewModelScope.launch {
            colorFlow.collect {
                _colorFlow.tryEmit(it)
                stateFlow.tryEmit(
                    Success(
                        "Color ${
                            String.format(
                                "#%06X",
                                0xFFFFFF and it
                            )
                        } received!"
                    )
                )
            }
        }
    }
}