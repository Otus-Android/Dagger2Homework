package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val sharedFlow: SharedFlow<Int>
) : ViewModel() {
    private val mutableStateFlow = MutableStateFlow(0)
    val stateFlow = mutableStateFlow

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

//        mutableStateFlow.value = channel.receive()
    }

    class ReceiverViewModelFactory @Inject constructor(
        private val context: Context,
        private val sharedFlow: SharedFlow<Int>
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModelReceiver::class.java))
                return ViewModelReceiver(context, sharedFlow) as T
            else
                throw IllegalArgumentException()
        }
    }
}