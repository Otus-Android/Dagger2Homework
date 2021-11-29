package ru.otus.daggerhomework.presentation.receiver

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.StateFlow
import ru.otus.daggerhomework.utils.ApplicationContext
import javax.inject.Inject

class ViewModelReceiver(
    private val state: StateFlow<Int>,
    @ApplicationContext
    private val context: Context
) : ViewModel() {

    fun observeColors(action: (Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        action.invoke(state.value)
    }
}

class ViewModelReceiverFactory @Inject constructor(
    private val state: StateFlow<Int>,
    @ApplicationContext
    private val context: Context
) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelReceiver(state, context) as T
    }

}