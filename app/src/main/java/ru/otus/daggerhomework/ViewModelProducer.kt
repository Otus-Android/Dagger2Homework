package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.di.annotation.ActivityContext
import ru.otus.daggerhomework.di.annotation.scope.FragmentProducerScope
import javax.inject.Inject

@FragmentProducerScope
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorEventSource: ColorEventSource,
    @ActivityContext private val context: Context
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorEventSource.sentNewColor(colorGenerator.generateColor())
    }
}