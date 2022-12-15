package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.otus.daggerhomework.di.ActivityScope
import javax.inject.Inject
import javax.inject.Named

@ActivityScope
class ViewModelReceiver @Inject constructor(
    @Named("appContext") val context: Context,
    private val colorStateFlow: MutableStateFlow<Int>
) : ViewModel() {

    private val _colorState: MutableStateFlow<Int> = MutableStateFlow(0)
    val colorState: StateFlow<Int> = _colorState

    init {
        observeColors()
    }

    private fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")

        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                colorStateFlow.collect { color ->
                    Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                    _colorState.value = color
                }
            }
        }
    }
}
