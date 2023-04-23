package ru.otus.daggerhomework.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.usecases.ProvideColorsUseCase
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    provideColorUseCase: ProvideColorsUseCase
) {
    val color = provideColorUseCase.invoke()
    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}