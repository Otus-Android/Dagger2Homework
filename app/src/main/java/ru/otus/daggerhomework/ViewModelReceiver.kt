package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    colorProvider: ColorProvider
): ViewModel() {
    val colorState = colorProvider.colorState.onEach {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
    }

    class Factory @Inject constructor(private val application: Application,
                                      private val colorProvider: ColorProvider): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelReceiver(application, colorProvider) as T
        }
    }
}