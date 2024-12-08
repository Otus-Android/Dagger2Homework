package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val publisher: FlowCollector<ColorNumber>,
    @ApplicationContext private val context: Context
) : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    fun generateColor() {
        val color =  colorGenerator.generateColor()
        viewModelScope.launch {
            if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
                Toast.makeText(context, "Color sent: $color", Toast.LENGTH_LONG).show()
            publisher.emit(color)
        }
    }


    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun factory(
            colorGenerator: ColorGenerator,
            publisher: FlowCollector<ColorNumber>,
            context: Context
        ) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModelProducer(colorGenerator, publisher, context) as T
            }
        }
    }
}