package ru.otus.daggerhomework.ui

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.State
import ru.otus.daggerhomework.di.qualifiers.ActivityQualifier
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityQualifier private val context: Context,
    private val flow: MutableSharedFlow<State>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        viewModelScope.launch {
            try {
                flow.emit(State.Success(colorGenerator.generateColor()))
            } catch (e: Exception) {
                flow.emit(State.Error(e))
            }
        }
    }
}