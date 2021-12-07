package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface FragmentReceiverModule {

    @Binds
    fun bindReceiverViewModelFactory(viewModel: ViewModelReceiver.ViewModelReceiverFactory): ViewModelProvider.Factory

}