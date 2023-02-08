package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Named

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    @Named("ActivityContext") private val context: Context
) {

    fun generateColor() {
        if (context !is MainActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}