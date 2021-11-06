package ru.otus.daggerhomework

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer(
    private val colorState: MutableStateFlow<ColorState>,
    private val colorGenerator: ColorGenerator,
    private val context: Context
) : ViewModel() {
    
    fun onButtonClick() = generateColor()
    
    private fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        colorState.value = ColorState.Color(colorGenerator.generateColor())
    }
    
}

@Suppress("UNCHECKED_CAST")
class ViewModelProducerFactory @Inject constructor(
    private val colorState: MutableStateFlow<ColorState>,
    private val colorGenerator: ColorGenerator,
    @Named(NAME_ACTIVITY_CONTEXT) private val context: Context
) : ViewModelProvider.Factory {
    
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelProducer(colorState, colorGenerator, context) as T
    }
    
}
