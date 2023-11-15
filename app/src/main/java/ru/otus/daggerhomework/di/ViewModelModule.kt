package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    @Binds
    fun bindViewModelProducer(viewModel: ViewModelProducer): ViewModel

    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    @Binds
    fun bindChatContactsViewModel(viewModel: ViewModelReceiver): ViewModel
}