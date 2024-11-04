package ru.otus.daggerhomework.fragments

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import ru.otus.daggerhomework.R
import ru.otus.daggerhomework.main.ActivityContext
import ru.otus.daggerhomework.colorproducer.ColorGenerator
import ru.otus.daggerhomework.colorproducer.ColorProducer
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorProducer: ColorProducer,
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
) {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException(context.getString(R.string.check_context_activity))
        Toast.makeText(context, context.getString(R.string.color_sent), Toast.LENGTH_LONG).show()
        colorProducer.setColor(colorGenerator.generateColor())
    }
}