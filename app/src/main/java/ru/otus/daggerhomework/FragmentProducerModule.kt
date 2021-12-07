package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface FragmentProducerModule {

    @Binds
    fun bindReceiverViewModelFactory(viewModel: ViewModelProducer.ViewModelProducerFactory): ViewModelProvider.Factory

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}