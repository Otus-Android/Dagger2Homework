package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.*
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorReceiver: ColorReceiver,
    private val colorGenerator: ColorGenerator,
    @ActivityContext
    private val context: Context
) {
    private val viewModelScope = CoroutineScope(Dispatchers.Main + Job())

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        viewModelScope.launch {
            colorReceiver.receiveColor(colorGenerator.generateColor())
        }
    }

    fun onCleared() {
        viewModelScope.cancel()
    }
}