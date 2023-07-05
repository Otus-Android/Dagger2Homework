package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val eventBus: EventBus,
    private val colorGenerator: ColorGenerator,
    private val context: Context
) {

    fun generateColor() = runBlocking {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        launch(Dispatchers.Default) {
            eventBus.postEvent(colorGenerator.generateColor())
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }
}

class ViewModelProducerFactory @Inject constructor(private val eventBus: EventBus,
                               private val colorGenerator: ColorGenerator,
                               private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelProducer(eventBus, colorGenerator, context) as T //super.create(modelClass)
    }
}