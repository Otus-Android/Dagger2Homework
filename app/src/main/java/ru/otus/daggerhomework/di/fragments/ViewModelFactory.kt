package ru.otus.daggerhomework.di.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ViewModelProducer::class.java -> {
                viewModelMap[modelClass]?.get() as T
            }
            ViewModelReceiver::class.java -> {
                viewModelMap[modelClass]?.get() as T
            }
            else -> {
                error("Unknown $modelClass")
            }
        }
    }
}