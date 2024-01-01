package ru.otus.daggerhomework.ui

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorSharedFlowContainer
import ru.otus.daggerhomework.State
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val colorSharedFlowContainer: ColorSharedFlowContainer
) : ViewModel() {

    fun generateColor(context: Context) {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        val colorFlow = colorSharedFlowContainer.getFlowAsProducer(context)
        viewModelScope.launch {
            try {
                colorFlow.emit(State.Success(colorGenerator.generateColor()))
            } catch (e: Exception) {
                colorFlow.emit(State.Error(e))
            }
        }
    }
}