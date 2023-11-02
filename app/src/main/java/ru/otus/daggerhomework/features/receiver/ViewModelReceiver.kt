package ru.otus.daggerhomework.features.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.utils.ColorChangeObserver
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val colorChangeObserver: ColorChangeObserver,
    @AppContext
    private val context: Context,
) {
    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorChangeObserver.changeEvent.onEach {
            Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        }
    }
}