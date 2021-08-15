package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelProducer(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val scopedStateFlow: MutableStateFlow<Events>
) : ViewModel() {

    private val _stateFlow : MutableStateFlow<ProducerEvents> = MutableStateFlow(ProducerEvents.Empty)
    val stateFlow = _stateFlow.asStateFlow()

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        scopedStateFlow.value = Events.SetColor(colorGenerator.generateColor())
        _stateFlow.value = ProducerEvents.OpenReceiver
    }

    fun onFragmentReceiverOpened() {
        _stateFlow.value = ProducerEvents.Empty
    }
}