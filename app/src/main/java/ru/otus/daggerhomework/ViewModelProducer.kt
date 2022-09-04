package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val eventObserver: MutableStateFlow<Event>,
): ViewModel() {
    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        viewModelScope.launch {
            eventObserver.emit(Event.ChangeColor(colorGenerator.generateColor()))
        }

        Log.e("ViewModelProducer", "Color sent")

        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }
}

class ViewModelProducerProviderFactory
    @Inject constructor(
        private val colorGenerator: ColorGenerator,
        @ActivityContext private val context: Context,
        @EventObserver private val eventObserver: MutableStateFlow<Event>,
    )
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProducer::class.java))
            return ViewModelProducer(colorGenerator, context, eventObserver) as T
        else throw IllegalArgumentException()
    }
}

