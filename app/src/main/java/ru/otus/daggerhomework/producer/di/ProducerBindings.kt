package ru.otus.daggerhomework.producer.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.common.ViewModelKey
import ru.otus.daggerhomework.producer.ViewModelProducer

@Module
interface ProducerBindings {

    @Binds
    @[IntoMap ViewModelKey(ViewModelProducer::class)]
    fun bindViewModelProducer(viewModel: ViewModelProducer): ViewModel

    @Binds
    fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator

}