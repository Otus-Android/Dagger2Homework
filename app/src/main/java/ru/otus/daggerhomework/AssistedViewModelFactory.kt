package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AssistedViewModelFactory<T: ViewModel>(
    private val factory: () -> T
) : ViewModelProvider.Factory {
    override fun <TR : ViewModel> create(modelClass: Class<TR>): TR {
        val viewModel: T = factory.invoke()

        require(modelClass.isInstance(viewModel))

        @Suppress("UNCHECKED_CAST")
        return factory.invoke() as TR
    }
}

