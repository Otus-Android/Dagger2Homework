package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import kotlinx.coroutines.channels.ReceiveChannel
import javax.inject.Inject

class ViewModelReceiver
@Inject constructor(
    @AppContext private val context: Context,
    private val receiveChannel: ReceiveChannel<Int>
) {

    fun observeColors(): ReceiveChannel<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return receiveChannel
    }
}