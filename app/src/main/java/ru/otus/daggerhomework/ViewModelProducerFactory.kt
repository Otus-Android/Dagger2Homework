package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.ActivityContext

/**
 * @author Юрий Польщиков on 08.08.2021
 */
class ViewModelProducerFactory(
    private val colorGenerator: ColorGenerator,
    private val flowObserver: FlowObserver<Int>,
    @ActivityContext private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelProducer(colorGenerator, flowObserver, context) as T
    }
}
