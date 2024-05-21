package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ApplicationContext private val context: Context,
    private val appObserver: AppObserver
): ViewModel() {
    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val color = colorGenerator.generateColor()
        appObserver.sendColor(color)
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}