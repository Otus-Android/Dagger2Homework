package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject
import ru.otus.daggerhomework.qualifiers.ActivityContext
import ru.otus.daggerhomework.scopes.FragmentScope

@FragmentScope
class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val colorProducer : ColorProducer
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        colorProducer.sendColor(colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}