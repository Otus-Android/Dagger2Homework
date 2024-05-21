package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelReceiverModule {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    fun bindLoginViewModel(viewModel: ViewModelReceiver): ViewModel
}