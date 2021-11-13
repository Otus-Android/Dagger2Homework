package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val channel: Channel<Result>,
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        viewModelScope.launch {
            if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
            Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
            ensureActive()
            channel.send(Result.Success(colorGenerator.generateColor()))
        }
    }

    class Factory(
        val colorGenerator: ColorGenerator,
        val channel: Channel<Result>,
        val context: Context
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelProducer(colorGenerator, channel, context) as T
        }
    }
}
