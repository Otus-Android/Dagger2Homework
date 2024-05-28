package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module

@FeatureScope
@Component(
  modules = [ProducerModule::class],
  dependencies = [MainActivityComponent::class],
)
interface ProducerComponent {
  companion object {
    fun getProducerComponent(cmpt: MainActivityComponent): ProducerComponent {
      return DaggerProducerComponent
        .builder()
        .mainActivityComponent(cmpt)
        .build()
    }
  }

  fun inject(fragmentProducer: FragmentProducer)
}

@Module
interface ProducerModule {
  @Binds
  fun bindFactory(factory: ViewModelProducerFactory): ViewModelProvider.Factory

  @Binds
  fun bindColorGenerator(impl: ColorGeneratorImpl): ColorGenerator
}