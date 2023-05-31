package ru.otus.daggerhomework

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class AssistedSavedStateViewModelFactory<T: ViewModel>(
    storeOwner: SavedStateRegistryOwner,
    private val factory: (stateHandle: SavedStateHandle) -> T
) : AbstractSavedStateViewModelFactory(storeOwner, null) {
    override fun <TR : ViewModel> create(
        _key: String,
        modelClass: Class<TR>,
        stateHandle: SavedStateHandle
    ): TR {
        val viewModel: T = factory.invoke(stateHandle)

        require(modelClass.isInstance(viewModel))

        @Suppress("UNCHECKED_CAST")
        return viewModel as TR
    }

}