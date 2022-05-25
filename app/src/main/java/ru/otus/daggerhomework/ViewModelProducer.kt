package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorFlow: MutableStateFlow<Color>,
    private val colorGenerator: ColorGenerator,
    @ActivityContextQualifier private val context: Context
) : ViewModel() {

    fun generateColor() {

        viewModelScope.launch {
            colorFlow.tryEmit(Color(colorGenerator.generateColor()))
        }

        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}