package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelReceiver

@Module
interface FragmentReceiverModule {
  @Binds
  @IntoMap
  @ViewModelKey(ViewModelReceiver::class)
  fun bindViewModelReceiver(viewModelReceiver: ViewModelReceiver): ViewModel
}
