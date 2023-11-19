package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ui.ViewModelProducer
import ru.otus.daggerhomework.ui.ViewModelReceiver
import ru.otus.daggerhomework.di.keys.ViewModelKey

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    @Binds
    fun bindViewModelProducer(viewModel: ViewModelProducer): ViewModel

    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    @Binds
    fun bindViewModelReceiver(viewModel: ViewModelReceiver): ViewModel
}