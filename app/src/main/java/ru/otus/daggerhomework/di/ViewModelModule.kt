package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}