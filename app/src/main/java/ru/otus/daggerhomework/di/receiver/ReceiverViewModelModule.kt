package ru.otus.daggerhomework.di.receiver

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.reciever.ViewModelReceiverFactory

@Module
interface ReceiverViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelProvider: ViewModelReceiverFactory): ViewModelProvider.Factory
}