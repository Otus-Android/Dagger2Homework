package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelProviderFactory<T : ViewModel>(private val create: () -> T) : ViewModelProvider.Factory {
    override fun <K : ViewModel> create(modelClass: Class<K>): K = create.invoke() as K
}