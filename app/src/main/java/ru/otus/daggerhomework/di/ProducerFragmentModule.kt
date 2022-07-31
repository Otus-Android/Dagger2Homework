package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ViewModelProducer

@Module
abstract class ProducerFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    internal abstract fun producerViewModel(viewModel: ViewModelProducer): ViewModel
}