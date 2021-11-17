package ru.otus.daggerhomework.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import javax.inject.Named

class ReceiverViewModel @Inject constructor(
    @Named("appContext") private val context: Context,
    private val provideEvent: MutableLiveData<Int>,
) : ViewModel() {

    val event = provideEvent

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}