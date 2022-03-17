package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentProducerModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun producerViewModel(viewModel: ViewModelProducer): ViewModel

    @Binds
    fun bindsColorGenerator(generator: ColorGeneratorImpl): ColorGenerator
}