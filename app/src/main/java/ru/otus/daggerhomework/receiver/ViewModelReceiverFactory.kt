package ru.otus.daggerhomework.receiver

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelReceiverFactory @Inject constructor(
    @ApplicationContext private val context: Context,
    private val stateFlow: MutableStateFlow<Int>
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelReceiver(context,stateFlow) as T
    }
}