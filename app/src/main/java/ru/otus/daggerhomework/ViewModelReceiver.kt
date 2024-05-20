package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelReceiver(
    private val context: Context,
    private val flow: StateFlow<Int>
) : ViewModel() {
    fun observeColors(onColorReceived: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            flow.collect {
                onColorReceived(it)
            }
        }
    }
}

class ViewModelReceiverFactory @Inject constructor(
    private val context: Context,
    private val flow: MutableStateFlow<Int>
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelReceiver(context = context, flow = flow) as T

}