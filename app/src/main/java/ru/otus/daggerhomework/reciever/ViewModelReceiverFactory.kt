package ru.otus.daggerhomework.reciever

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
    private val producerFlow: MutableStateFlow<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            return ViewModelReceiver(context, producerFlow) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}