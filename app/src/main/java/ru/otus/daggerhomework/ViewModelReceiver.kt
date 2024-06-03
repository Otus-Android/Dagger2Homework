package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@ReceiverScope
class ViewModelReceiver @Inject constructor(
    private val eventsObserver: EventsObserver,
    @ApplicationContext private val context: Context
) {
    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        return eventsObserver.getEvents().filterNotNull().onEach {
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        }
    }
}