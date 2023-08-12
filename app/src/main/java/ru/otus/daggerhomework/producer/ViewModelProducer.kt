package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.activity.Event

class ViewModelProducer(
    private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val eventUpdater: MutableStateFlow<Event?>
) {

    fun generateColor() {
        if (context !is FragmentActivity)  {
            throw RuntimeException("Здесь нужен контекст активити")
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}