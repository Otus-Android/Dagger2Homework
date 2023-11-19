package ru.otus.daggerhomework.ui

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.State
import ru.otus.daggerhomework.di.qualifiers.ApplicationQualifier
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @ApplicationQualifier private val context: Context,
    flow: MutableSharedFlow<State>
) : ViewModel() {

    private val sharedFlow = flow.asSharedFlow()

    fun observeColors(onChanged: (colorInt: Int) -> Unit) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            sharedFlow.collect { state ->
                when(state) {
                    is State.Success -> {
                        onChanged(state.color)
                    }
                    is State.Error -> {
                        Log.d("FragmentReceiver", state.throwable.message.toString())
                    }
                }
            }
        }
    }
}