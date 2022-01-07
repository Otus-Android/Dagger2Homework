package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ViewModelProducer

@Module
interface FragmentProducerModule {
  @Binds
  @IntoMap
  @ViewModelKey(ViewModelProducer::class)
  fun bindViewModelProducer(viewModelProducer: ViewModelProducer): ViewModel

  @Binds
  fun bindColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}
