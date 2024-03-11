package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val observer: MutableStateFlow<Int>,
): ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            observer.emit(colorGenerator.generateColor())
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }

    class Factory(
        private val colorGenerator: ColorGenerator,
        private val context: Context,
        private val observer: MutableStateFlow<Int>,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
                ViewModelProducer(colorGenerator, context, observer) as T
            } else {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }

    }

}