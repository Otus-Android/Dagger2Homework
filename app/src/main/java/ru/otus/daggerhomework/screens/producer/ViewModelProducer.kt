package ru.otus.daggerhomework.screens.producer

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.observer.ColorGenerationStateEmitter
import ru.otus.daggerhomework.generator.ColorGenerator
import ru.otus.daggerhomework.observer.ColorState
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

class ViewModelProducer @Inject constructor(
    @ActivityContext
    private val context: Context,
    private val colorGenerator: ColorGenerator,
    private val emitter: ColorGenerationStateEmitter
) : ViewModel() {

    fun generateColor() {
        viewModelScope.launch {
            val generatedColor = colorGenerator.generateColor()
            emitter.emit(ColorState.Color(generatedColor))

            if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
            Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()
        }
    }

    fun reset() {
        viewModelScope.launch {
            emitter.emit(ColorState.Default)
        }
    }
}