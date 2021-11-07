package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelProviderFactory<VM : ViewModel>(private val vmCreator: () -> VM) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = vmCreator.invoke() as T
}