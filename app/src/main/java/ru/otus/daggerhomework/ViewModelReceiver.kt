package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @AppContext private val context: Context,
    private val colorFlow: MutableStateFlow<Int?>,
) : ViewModel() {

    fun observeColors(): StateFlow<Int?> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        return colorFlow
    }
}