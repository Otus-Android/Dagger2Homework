package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelReceiver

@Module
abstract class ReceiverFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    internal abstract fun receiverViewModel(viewModel: ViewModelReceiver): ViewModel
}