package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException


class ViewModelProducer(
    private val context: Context,
    private val observer: MutableLiveData<Int>,
    private val colorGenerator: ColorGenerator
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        observer.postValue(colorGenerator.generateColor())
        Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
    }
}