package ru.otus.daggerhomework.di.fragments

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelReceiver

@Module
interface FragmentReceiverModule {

    @Binds
    @IntoMap
    @ViewModelKey(key = ViewModelReceiver::class)
    @FragmentScope
    fun bindViewModelReceiver(impl: ViewModelReceiver): ViewModel

}
