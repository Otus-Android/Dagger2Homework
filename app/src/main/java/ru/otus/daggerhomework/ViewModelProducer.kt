package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class ViewModelProducer
@Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val channel: Channel<Int>
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        channel.trySend(colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}