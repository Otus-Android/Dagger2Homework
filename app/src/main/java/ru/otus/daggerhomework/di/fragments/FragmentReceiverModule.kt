package ru.otus.daggerhomework.di.fragments

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ViewModelMarkerInterface
import ru.otus.daggerhomework.ViewModelReceiver2

@Module
interface FragmentReceiverModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(key = ViewModelReceiver::class)
//    @FragmentScope
//    fun bindViewModelReceiver(impl: ViewModelReceiver): ViewModel

    @Binds
    @FragmentScope
    fun bindViewModelReceiver2(impl: ViewModelReceiver2): ViewModelMarkerInterface
}
