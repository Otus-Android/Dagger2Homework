package ru.otus.daggerhomework.di.modules.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.viewModels.ViewModelReceiver

@Module
interface ViewModelModuleFragmentReceiver {
    @IntoMap
    @ViewModelKey(ViewModelReceiver::class)
    @Binds
    fun provideViewModeReceiver(viewModel: ViewModelReceiver): ViewModel

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}