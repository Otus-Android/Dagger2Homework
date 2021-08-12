package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ViewModelProducer.ProducerViewModelFactory
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ProducerViewModel

@Module(subcomponents = [FragmentProducerComponent::class])
abstract class FragmentProducerModule {

    @ProducerViewModel
    @Binds
    abstract fun bindProducerViewModelFactory(producerViewModelFactory: ProducerViewModelFactory): ViewModelProvider.Factory
}