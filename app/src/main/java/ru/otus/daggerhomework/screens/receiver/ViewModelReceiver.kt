package ru.otus.daggerhomework.screens.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.observer.ColorGenerationStateObserver
import ru.otus.daggerhomework.observer.ColorState
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val stateObserver: ColorGenerationStateObserver
) : ViewModel() {

    suspend fun observeColors(): Flow<ColorState> {
        return stateObserver.receive().onEach { state ->
            if (state != ColorState.Default) {
                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }
        }
    }
}