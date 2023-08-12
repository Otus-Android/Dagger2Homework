package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val observer: CustomObserver,
    private val context: Context
) {

    init {
        Log.d("TAG", "ViewModelReceiver: $observer")
    }

    val colorFlow: StateFlow<Int> = observer.observeColor()

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }
}