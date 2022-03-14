package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

// taken from: https://medium.com/@vit.onix/dagger2-viewmodel-81d4cd59f642

class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val viewModelProvider = viewModels[modelClass] ?: throw IllegalArgumentException("model class $modelClass not found")
    return viewModelProvider.get() as T
  }
}
