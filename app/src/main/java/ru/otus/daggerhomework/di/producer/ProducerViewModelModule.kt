package ru.otus.daggerhomework.di.producer

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.producer.ViewModelProducerFactory

@Module
interface ProducerViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelProvider: ViewModelProducerFactory): ViewModelProvider.Factory
}