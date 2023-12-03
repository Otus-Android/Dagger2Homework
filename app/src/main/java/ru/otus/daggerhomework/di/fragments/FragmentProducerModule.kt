package ru.otus.daggerhomework.di.fragments

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelProducer

@Module
interface FragmentProducerModule {

    @FragmentScope
    @Binds
    fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator

    @Binds
    @IntoMap
    @ViewModelKey(key = ViewModelProducer::class)
    @FragmentScope
    fun bindViewModelProducer(impl: ViewModelProducer): ViewModel
}