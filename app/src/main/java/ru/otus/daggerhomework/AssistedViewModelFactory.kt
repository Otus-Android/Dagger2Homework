package ru.otus.daggerhomework

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

class AssistedViewModelFactory<T: ViewModel>(
    private val factory: () -> T
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return factory.invoke() as T
    }
}

class AssistedSavedStateViewModelFactory<T: ViewModel>(
    storeOwner: SavedStateRegistryOwner,
    private val factory: (stateHandle: SavedStateHandle) -> T
) : AbstractSavedStateViewModelFactory(storeOwner, null) {
    override fun <T : ViewModel> create(
        _key: String,
        modelClass: Class<T>,
        stateHandle: SavedStateHandle
    ): T {
        val viewModel = factory.invoke(stateHandle)

        @Suppress("UNCHECKED_CAST")
        return viewModel as T
    }

}