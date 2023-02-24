package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val colorRepository: ColorRepository
) {

    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorRepository.getColorFlow()
    }
}