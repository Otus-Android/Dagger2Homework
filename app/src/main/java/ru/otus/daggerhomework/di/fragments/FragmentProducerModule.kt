package ru.otus.daggerhomework.di.fragments

import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelMarkerInterface
import ru.otus.daggerhomework.ViewModelProducer2

@Module
interface FragmentProducerModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

//    @Binds
//    @IntoMap
//    @ViewModelKey(key = ViewModelProducer::class)
//    @FragmentScope
//    fun bindViewModelProducer(impl: ViewModelProducer): ViewModel

    @Binds
    @FragmentScope
    fun bindViewModelProducer2(impl: ViewModelProducer2): ViewModelMarkerInterface
}