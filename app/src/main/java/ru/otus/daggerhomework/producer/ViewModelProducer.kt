package ru.otus.daggerhomework.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.components.DataModule
import ru.otus.daggerhomework.components.State
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    @Named("ActivityContext") private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val colorFlow: MutableSharedFlow<Int>,
    private val stateFlow: MutableSharedFlow<State>
) : ViewModel(){
    val state = MutableLiveData<State>()

    init {
        viewModelScope.launch {
            stateFlow.collect{
                state.value = it
            }
        }
    }

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        sendColor()
    }
    fun sendColor(){
        viewModelScope.launch {
            colorFlow.tryEmit(colorGenerator.generateColor())
        }
    }
}