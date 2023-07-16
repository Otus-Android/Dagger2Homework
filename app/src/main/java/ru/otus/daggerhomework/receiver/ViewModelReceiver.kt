package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.utils.Notification
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext
    private val context: Context,
    private val notification: Notification,
    private val lifecycleCoroutineScope: LifecycleCoroutineScope
) {
    fun observeColors(observer: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        lifecycleCoroutineScope.launch {
            notification.events.collect { colorEvent ->
                Toast.makeText(context, "Color received $colorEvent", Toast.LENGTH_LONG).show()
                observer.invoke(colorEvent)
            }
        }
    }
}