package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentReceiverModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun receiverViewModel(viewModel: ViewModelReceiver): ViewModel
}