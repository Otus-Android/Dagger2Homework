package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory(): ViewModelProvider.Factory {
    @Inject
    lateinit var viewModelProducerProvider : Provider<ViewModelProducer>

    @Inject
    lateinit var viewModelReceiverProvider : Provider<ViewModelReceiver>

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelProducer::class.java)) {
            return viewModelProducerProvider.get() as T
        } else if (modelClass.isAssignableFrom(ViewModelReceiver::class.java)) {
            return viewModelReceiverProvider.get() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}