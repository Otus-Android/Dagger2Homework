package ru.otus.daggerhomework

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val transceiver: Transceiver
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            transceiver.send(colorGenerator.generateColor())
            Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        }
    }
}

class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val transceiver: Transceiver
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelProducer(colorGenerator, context, transceiver) as T
    }
}