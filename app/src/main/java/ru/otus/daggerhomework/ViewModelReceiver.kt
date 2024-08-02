package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import ru.otus.daggerhomework.di.ApplicationContext
import ru.otus.daggerhomework.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class ViewModelReceiver @Inject constructor(
    private val colorRepositoryReadOnly: ColorRepositoryReadOnly,
    @ApplicationContext private val context: Context
) {

    fun observeColors(): Flow<GeneratedColor> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorRepositoryReadOnly.colorFlow.onEach {
            Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
        }
    }
}