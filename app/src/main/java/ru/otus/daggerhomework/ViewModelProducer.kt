package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.qualifiers.ActivityScope
import ru.otus.daggerhomework.qualifiers.ApplicationScope
import java.lang.RuntimeException
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val context: Context,
    private val colorStateFlow: MutableStateFlow<Int>
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        val currentColor = colorGenerator.generateColor()
        viewModelScope.launch {
            colorStateFlow.emit(currentColor)
        }
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
    }
}