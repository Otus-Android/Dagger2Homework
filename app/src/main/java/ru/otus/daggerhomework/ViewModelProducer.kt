package ru.otus.daggerhomework

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val eventObserver: EventObserver,
    private val context: Context
) : ViewModel() {

    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        eventObserver.sendEvent(color)
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }

    @Suppress("UNCHECKED_CAST")
    @ProducerScope
    class ViewModelFactory @Inject constructor(
        private val colorGenerator: ColorGenerator,
        private val eventObserver: EventObserver,
        @ActivityContext private val context: Context
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelProducer(colorGenerator, eventObserver, context) as T
        }
    }
}