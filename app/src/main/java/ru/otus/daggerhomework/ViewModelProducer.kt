package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

@ProducerScope
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val eventsProducer: EventsProducer,
    @ActivityContext private val context: Context
) {
    suspend fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        eventsProducer.emit(color)
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}