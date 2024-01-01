package ru.otus.daggerhomework.ui

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorSharedFlowContainer
import ru.otus.daggerhomework.State
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    private val colorSharedFlowContainer: ColorSharedFlowContainer
) : ViewModel() {

    fun observeColors(context: Context, onChanged: (colorInt: Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        val colorFlow = colorSharedFlowContainer.getFlowAsReceiver()
        viewModelScope.launch {
            colorFlow.collect { state ->
                when(state) {
                    is State.Success -> { onChanged(state.color) }
                    is State.Error -> {
                        Log.d("FragmentReceiver", state.throwable.message.toString())
                    }
                }
            }
        }
    }
}