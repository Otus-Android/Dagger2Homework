package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelProducerModule {
    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun bindMainViewModel(viewModel: ViewModelProducer): ViewModel
}