package ru.otus.daggerhomework.presentation

import android.app.Application
import android.content.Context
import kotlinx.coroutines.flow.Flow
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorFlow: Flow<Int>
) {

    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorFlow
    }
}