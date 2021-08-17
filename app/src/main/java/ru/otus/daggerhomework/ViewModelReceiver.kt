package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val context: Context,
    private val mutableSharedFlow: MutableSharedFlow<Int>
) : ViewModel() {
    private val mutableStateFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = mutableStateFlow

    suspend fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            mutableSharedFlow.collect {
                mutableStateFlow.value = it
            }
        }
    }

    class ReceiverViewModelFactory @Inject constructor(
        private val context: Context,
        private val mutableSharedFlow: MutableSharedFlow<Int>
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ViewModelReceiver::class.java))
                return ViewModelReceiver(context, mutableSharedFlow) as T
            else
                throw IllegalArgumentException()
        }
    }
}