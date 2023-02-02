package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

class ViewModelProducer(
    private val observer: Observer,
    private val colorGenerator: ColorGenerator,
    private val context: Context
):ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}

class ViewModelProducerFactory(private val observer: Observer,
                               private val colorGenerator: ColorGenerator,
                               private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelProducer(observer, colorGenerator, context) as T //super.create(modelClass)
    }
}