package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.Channel
import ru.otus.daggerhomework.app.App
import ru.otus.daggerhomework.app.ApplicationComponent

val Context.appComponent: ApplicationComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }

class Event<T> {

    private val channel = Channel<T>()

    suspend fun send(item: T) {
        channel.send(item)
    }

    fun consume(lifecycleOwner: LifecycleOwner, consumer: (T) -> Unit) {
        lifecycleOwner.lifecycleScope.launchWhenStarted {
            for (item in channel) consumer(item)
        }
    }
}
