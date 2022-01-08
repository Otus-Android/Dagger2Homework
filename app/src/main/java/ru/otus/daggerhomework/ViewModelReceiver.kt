package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

@SuppressLint("StaticFieldLeak")
class ViewModelReceiver @Inject constructor(
    @Named("application") private val context: Context,
    private val state: MutableStateFlow<Int>
) : ViewModel() {

    private var colorUpdatesJob: Job? = null

    fun observeColors(action: ((Int) -> Unit)?) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        colorUpdatesJob = viewModelScope.launch {
            state.collect {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                action?.invoke(it)
            }
        }
    }

    fun stopObservingColors() {
        colorUpdatesJob?.cancel()
    }
}
