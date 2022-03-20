package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver
import ru.otus.daggerhomework.viewmodels.ViewModelFactory
import ru.otus.daggerhomework.viewmodels.ViewModelKey
import javax.inject.Singleton

@Module
abstract class ViewModelModule {


    @Binds
    @Singleton
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    internal abstract fun viewModelProducer(viewModel: ViewModelProducer): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    internal abstract fun viewModelReceiver(viewModel: ViewModelReceiver): ViewModel

}