package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import ru.otus.daggerhomework.Event
import javax.inject.Inject

class ReceiverViewModel @Inject constructor(
    private val context: Context,
    private val event: Event<Int>
) : ViewModel() {

    fun observeColors(lifecycleOwner: LifecycleOwner, observer: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        event.consume(lifecycleOwner) {
            observer(it)
        }
    }
}
