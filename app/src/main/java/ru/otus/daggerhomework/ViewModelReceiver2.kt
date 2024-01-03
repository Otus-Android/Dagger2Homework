package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.app.ApplicationContextQualifier
import javax.inject.Inject

class ViewModelReceiver2 @Inject constructor(
    private val observer: ReceiveChannel<@JvmSuppressWildcards LocalEvent>,
    @ApplicationContextQualifier
    private val applicationContext: Context
) : ViewModelMarkerInterface {

    private val viewModelScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    fun observeColors(populate: (color: Int) -> Unit) {
        if (applicationContext !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        viewModelScope.launch {
            observer.consumeAsFlow().collect { event ->

                when (event) {
                    is LocalEvent.ColorData -> {
                        populate(event.color)
                        Toast.makeText(applicationContext, "Color received", Toast.LENGTH_SHORT).show()
                    }

                    is LocalEvent.Error -> {
                        Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}