package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val flowObserver: FlowObserver<Int>,
    private val context: Context,
) : ViewModel() {

    suspend fun generateColor() {
        flowObserver.emitValue(colorGenerator.generateColor())

        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }
}
