package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelReceiver constructor (
    private val context: Context,
    val state: MutableStateFlow<Int>
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow<Int>(0)
    val stateFlow: StateFlow<Int>
        get() = mutableStateFlow
    init {
        observeColors()
    }

    fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        viewModelScope.launch {
            state.collect {
                Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
                mutableStateFlow.value = it
            }
        }
    }
}

class ReceiverFactory @Inject constructor(
    @ApplicationContext  private val context: Context,
    val state: MutableStateFlow<Int>): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelReceiver(context, state) as T
    }
}