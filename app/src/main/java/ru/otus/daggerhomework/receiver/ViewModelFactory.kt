package ru.otus.daggerhomework.receiver

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.components.State
import javax.inject.Inject
import javax.inject.Named

class ViewModelFactory @Inject constructor(
    @Named("ApplicationContext") private val context: Context,
    private val colorFlow: MutableSharedFlow<Int>,
    private val stateFlow: MutableStateFlow<State>
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelReceiver(context, colorFlow, stateFlow) as T
}