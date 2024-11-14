package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory  @Inject constructor(
    private val viewModels: Map<Class<*>, @JvmSuppressWildcards ViewModel>
) : ViewModelProvider.Factory {

     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModels[modelClass] as T
    }

}