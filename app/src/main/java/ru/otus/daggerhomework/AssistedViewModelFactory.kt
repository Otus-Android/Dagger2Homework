package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AssistedViewModelFactory<T: ViewModel>(
    private val factory: () -> T
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return factory.invoke() as T
    }
}