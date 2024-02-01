package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val eventBus: EventBus,
    @ActivityContext private val context: Context
) {

    private val scope = CoroutineScope(Dispatchers.Main)

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        scope.launch {
            eventBus.publishEvent(colorGenerator.generateColor())
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }

    fun clear() {
        scope.coroutineContext.cancel()
    }
}