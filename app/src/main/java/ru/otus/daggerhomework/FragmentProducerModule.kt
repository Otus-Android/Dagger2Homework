package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface FragmentProducerModule {

    @Binds
    @FragmentScope
    fun bindsColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    fun bindsViewModelProducer(viewModelProducer: ViewModelProducer): ViewModel
}