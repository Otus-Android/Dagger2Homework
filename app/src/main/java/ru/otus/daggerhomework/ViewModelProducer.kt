package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorObserver: ColorObserver
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            colorObserver.send(colorGenerator.generateColor())
            Toast.makeText(context, "Color sent", Toast.LENGTH_SHORT).show()
        }
    }
}