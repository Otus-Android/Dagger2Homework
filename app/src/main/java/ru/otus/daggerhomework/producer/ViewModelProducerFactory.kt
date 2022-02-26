package ru.otus.daggerhomework.producer

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.di.ActivityContext
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelProducerFactory @Inject constructor(
    private val colorGenerator: ColorGenerator,
    @ActivityContext private val context: Context,
    private val producerFlow: MutableStateFlow<Int>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
            return ViewModelProducer(colorGenerator, context, producerFlow) as T
        } else {
            throw IllegalArgumentException("Cannot instantiate ViewModel: $modelClass")
        }
    }
}