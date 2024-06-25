package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.qualifiers.ViewModelKey

@Module
interface ReceiverModule {
    @Binds
    @[IntoMap ViewModelKey(ViewModelReceiver::class)]
    fun provideViewModelReceiver(viewModel: ViewModelReceiver): ViewModel
}
