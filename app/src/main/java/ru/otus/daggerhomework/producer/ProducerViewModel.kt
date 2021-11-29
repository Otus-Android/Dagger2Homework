package ru.otus.daggerhomework.producer

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.Event
import javax.inject.Inject

class ProducerViewModel @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val event: Event<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            event.send(colorGenerator.generateColor())
        }
    }
}
