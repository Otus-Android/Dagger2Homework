package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.di.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val mutableStateFlow: MutableStateFlow<Int>,
    @AppContext private val context: Context
) {

    fun observeColors(): MutableStateFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return mutableStateFlow
    }
}