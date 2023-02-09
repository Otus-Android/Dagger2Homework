package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Named

class ViewModelReceiver(
    @Named("ApplicationContext") private val context: Context,
    val stateChanel: MutableStateFlow<Int>
):ViewModel() {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color ${stateChanel.value} received", Toast.LENGTH_LONG).show()
    }
}