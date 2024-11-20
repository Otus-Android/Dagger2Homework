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
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val publisher: FlowCollector<Color>,
    private val context: Context
) : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    fun generateColor() {
        val color =  colorGenerator.generateColor()
        viewModelScope.launch {
            publisher.emit(color)
            if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
            Toast.makeText(context, "Color sent: $color", Toast.LENGTH_LONG).show()
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
            publisher: FlowCollector<Color>,
            context: Context
        ) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ViewModelProducer(colorGenerator, publisher, context) as T
            }
        }
    }
}