package ru.otus.daggerhomework.producer

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelKey
import ru.otus.daggerhomework.ViewModelModule

@Module(includes = [ViewModelModule::class])
abstract class ProducerModule {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelProducer::class)
    abstract fun bind(viewModel: ViewModelProducer): ViewModel

    @Binds
    abstract fun bindColorGeneration(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}