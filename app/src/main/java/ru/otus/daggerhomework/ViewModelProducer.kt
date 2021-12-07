package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelProducer constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val mutableStateFlow: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            mutableStateFlow.emit(colorGenerator.generateColor())
        }

    }

    class ViewModelProducerFactory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @ActivityContext
        private val context: Context,
        private val mutableStateFlow: MutableStateFlow<Int>
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelProducer(colorGenerator, context, mutableStateFlow) as T
        }
    }
}