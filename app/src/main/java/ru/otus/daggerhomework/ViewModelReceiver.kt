package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val colorFlow: MutableStateFlow<Int>
) {

    fun observeColors(): Flow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        return colorFlow
    }
}