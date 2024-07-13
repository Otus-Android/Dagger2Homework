package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import javax.inject.Inject
import kotlinx.coroutines.flow.SharedFlow
import ru.otus.daggerhomework.qualifiers.AppContext
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
class ViewModelReceiver @Inject constructor(
    @AppContext private val context : Context,
    val colorReceiver : ColorReceiver
) {

    fun observeColors(): SharedFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorReceiver.listenColorEvent()
    }
}
