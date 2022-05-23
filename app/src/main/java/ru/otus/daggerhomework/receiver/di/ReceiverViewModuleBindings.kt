package ru.otus.daggerhomework.receiver.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.common.ViewModelKey
import ru.otus.daggerhomework.receiver.ViewModelReceiver

@Module
interface ReceiverViewModuleBindings {

    @Binds
    @[IntoMap ViewModelKey(ViewModelReceiver::class)]
    fun bindViewModelReceiver(viewModel: ViewModelReceiver): ViewModel

}