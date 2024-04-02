package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import ru.otus.daggerhomework.di.annotations.AppContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val stateColor: StateFlow<Int>
) {

    fun observeColors(): SharedFlow<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return stateColor
    }
}