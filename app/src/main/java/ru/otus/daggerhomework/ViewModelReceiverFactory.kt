package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.AppContext

/**
 * @author Юрий Польщиков on 08.08.2021
 */
class ViewModelReceiverFactory(
    private val flowObserver: FlowObserver<Int>,
    @AppContext private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelReceiver(flowObserver, context) as T
    }
}
