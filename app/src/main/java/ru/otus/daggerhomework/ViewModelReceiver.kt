package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.app.ApplicationContextQualifier
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val observer: Channel<LocalEvent>,
    @ApplicationContextQualifier
    private val context: Context
) : ViewModel() {

    fun observeColors(populate: (color: Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            observer.receiveAsFlow().collect { event ->
                when (event) {
                    is LocalEvent.ColorData -> {
                        populate(event.color)
                    }

                    is LocalEvent.Error -> {
                        Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    companion object {
        fun Factory(
            observer: Channel<LocalEvent>,
            @ApplicationContextQualifier
            appContext: Context
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return when (modelClass) {
                        ViewModelReceiver::class.java -> {
                            ViewModelReceiver(observer, appContext) as T
                        }

                        else -> {
                            error("Unknown $modelClass")
                        }
                    }
                }
            }
        }
    }
}