package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import javax.inject.Inject
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.qualifiers.AppContext

class ViewModelReceiver @Inject constructor(
    @AppContext private val context : Context,
    val colorReceiver : ColorReceiver
) : ViewModel() {

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            colorReceiver.listenColorEvent().collectLatest {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
            }
        }
    }
}
