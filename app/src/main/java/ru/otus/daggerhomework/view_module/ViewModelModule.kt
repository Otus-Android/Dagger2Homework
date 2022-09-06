package com.stupkalex.rostok.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelProducer
import ru.otus.daggerhomework.ViewModelReceiver

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun bindViewModelReceiver(viewModel: ViewModelReceiver): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun bindViewModelProducer(viewModel: ViewModelProducer): ViewModel


}