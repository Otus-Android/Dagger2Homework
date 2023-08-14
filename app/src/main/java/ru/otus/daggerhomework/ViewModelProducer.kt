package ru.otus.daggerhomework

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val producer: CustomProducer,
    private val colorGenerator: ColorGenerator,
    private val context: Context
) {

    init {
        Log.d("TAG", "ViewModelProducer: $producer")
    }

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")

        producer.produceColor(colorGenerator.generateColor())

        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}