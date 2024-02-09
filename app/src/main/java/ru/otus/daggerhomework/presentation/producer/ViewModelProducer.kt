package ru.otus.daggerhomework.presentation.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.util.ColorGenerator
import ru.otus.daggerhomework.util.EventSender
import ru.otus.daggerhomework.util.IntEvent

class ViewModelProducer @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    val colorGenerator: ColorGenerator,
    val eventFlow: EventSender
) : ViewModel() {

    fun generateColor(context: Context) {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        viewModelScope.launch {
            val color = colorGenerator.generateColor()
            eventFlow.send(IntEvent(color))
            Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        }
    }

    @AssistedFactory
    interface Factory {

        fun create(savedStateHandle: SavedStateHandle): ViewModelProducer
    }
}
