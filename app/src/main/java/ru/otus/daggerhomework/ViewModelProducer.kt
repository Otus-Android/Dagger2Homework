package ru.otus.daggerhomework

import android.app.Activity
import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelProducer(
    private val colorProvider: ColorProvider,
    private val colorGenerator: ColorGenerator,
    private val context: Context
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            colorProvider.sendColor(colorGenerator.generateColor())
        }
    }

    class Factory @Inject constructor(private val activity: Activity,
                                      private val colorGenerator: ColorGenerator,
                                      private val colorProvider: ColorProvider): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelProducer(colorProvider, colorGenerator, activity) as T
        }
    }
}