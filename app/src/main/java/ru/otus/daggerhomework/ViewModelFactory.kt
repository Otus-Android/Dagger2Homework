package ru.otus.daggerhomework

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.di.annotation.Activity
import ru.otus.daggerhomework.di.annotation.Application
import ru.otus.daggerhomework.di.annotation.scope.FragmentProducerScope
import ru.otus.daggerhomework.di.annotation.scope.FragmentReceiverScope
import javax.inject.Inject

@FragmentReceiverScope
class ReceiverViewModelFactory @Inject constructor(
    private val colorEventSource: ColorEventSource,
    @Application private val context: Context
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelReceiver(colorEventSource, context) as T
}

@FragmentProducerScope
class ProducerViewModelFactory @Inject constructor(
    private val colorEventSource: ColorEventSource,
    private val colorGenerator: ColorGenerator,
    @Activity private val context: Context
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ViewModelProducer(colorGenerator, colorEventSource, context) as T
}
