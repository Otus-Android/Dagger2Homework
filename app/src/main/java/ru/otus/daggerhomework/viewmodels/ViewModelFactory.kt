package ru.otus.daggerhomework.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.EventBusProducer
import ru.otus.daggerhomework.EventBusReceiver
import ru.otus.daggerhomework.di.ActivityContext
import ru.otus.daggerhomework.di.ApplicationContext
import javax.inject.Inject


class ViewModelFactory @Inject constructor(
    @ApplicationContext private val appContext: Context,
    @ActivityContext private val activityContext: Context,
    private val receiver: EventBusReceiver,
    private val producer: EventBusProducer,
    private val generator: ColorGenerator
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ViewModelProducer::class.java -> ViewModelProducer(
                generator,
                producer,
                activityContext
            ) as T
            ViewModelReceiver::class.java -> ViewModelReceiver(appContext, receiver) as T
            else -> throw IllegalStateException("Unknown class ${modelClass.name}")
        }
    }
}