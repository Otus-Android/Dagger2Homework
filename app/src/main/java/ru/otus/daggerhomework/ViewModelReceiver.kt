package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.colorexchanger.ColorExchanger
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationContext private val context: Context,
    private val colorExchanger: ColorExchanger
) : ViewModel() {

    val colorFlow = colorExchanger.getColorFlow()

    init {
        observeColors()
    }

    private fun observeColors() {
        viewModelScope.launch {
            colorFlow.filterNotNull().collect {
                if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
                Toast.makeText(context, "Color received", Toast.LENGTH_SHORT).show()
            }
        }
    }
}