package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class ViewModelReceiver
@Inject constructor(
    @AppContext private val context: Context,
    private val channel: Channel<Int>
) {

    fun observeColors(): Channel<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return channel
    }
}