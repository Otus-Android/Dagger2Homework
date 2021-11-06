package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.*
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver(
    colorState: StateFlow<ColorState>,
    private val context: Context
) : ViewModel() {
    
    val colors: Flow<ColorState.Color> = colorState
        .onStart {
            if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        }
        .onEach {
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        }
        .filterIsInstance()
    
}

@Suppress("UNCHECKED_CAST")
class ViewModelReceiverFactory @Inject constructor(
    private val colorState: StateFlow<@JvmSuppressWildcards ColorState>,
    @Named(NAME_APP_CONTEXT) private val context: Context
) : ViewModelProvider.Factory {
    
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelReceiver(colorState, context) as T
    }
    
}
