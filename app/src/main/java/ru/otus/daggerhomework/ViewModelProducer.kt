package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ViewModelProducer
@Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    @EventObserver private val eventObserver: MutableStateFlow<Event>,
) {

    private val viewModelProducerScope = ViewModelProducerScope()

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        viewModelProducerScope.launch {
            eventObserver.emit(Event.ChangeColor(colorGenerator.generateColor()))
        }

        Log.e("ViewModelProducer", "Color sent")

        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }

    fun cancelRunCoroutine() {
        viewModelProducerScope.cancel()
    }
}

class ViewModelProducerScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main + CoroutineName("ViewModelProducerScope")
}

