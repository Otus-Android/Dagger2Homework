package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import ru.otus.daggerhomework.EventObservable
import ru.otus.daggerhomework.receiver.di.FragmentReceiverComponent
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    @Named(FragmentReceiverComponent.APPLICATION_CONTEXT_QUALIFIER) private val context: Context,
    eventObservable: EventObservable
) : ViewModel() {

    val events = eventObservable.events

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}