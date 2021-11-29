package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    @Named("ApplicationContext")
    private val context: Context,
    private val receiver:MutableStateFlow<Int>
) : ViewModel() {
    private val _receiver = MutableStateFlow(0)
    val receiverStateFlow: StateFlow<Int> = _receiver


     fun observeColors() {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color передан + $context + $receiver", Toast.LENGTH_LONG).show()
                 _receiver.value=receiver.value
    }
}