package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.ReceiveChannel
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    private val context: Context,
    private val eventReceiver: ReceiveChannel<Int>
) : ViewModel() {

    fun observeColors(lifecycleOwner: LifecycleOwner, observer: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        lifecycleOwner.lifecycleScope.launchWhenStarted {
            for (item in eventReceiver) {
                observer(item)
            }
        }
    }
}
