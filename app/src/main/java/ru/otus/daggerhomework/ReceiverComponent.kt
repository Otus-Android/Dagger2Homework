package ru.otus.daggerhomework

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module

@FeatureScope
@Component(
  modules = [ReceiverModule::class],
  dependencies = [MainActivityComponent::class],
)
interface ReceiverComponent {
  companion object {
    fun getReceiverComponent(cmpt: MainActivityComponent): ReceiverComponent {
      return DaggerReceiverComponent
        .builder()
        .mainActivityComponent(cmpt)
        .build()
    }
  }

  fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
interface ReceiverModule {
  @Binds
  fun bindFactory(factory: ViewModelReceiverFactory): ViewModelProvider.Factory
}