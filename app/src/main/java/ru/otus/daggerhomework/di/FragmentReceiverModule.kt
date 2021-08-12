package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.otus.daggerhomework.ViewModelReceiver.ReceiverViewModelFactory
import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReceiverViewModel

@Module(subcomponents = [FragmentReceiverComponent::class])
abstract class FragmentReceiverModule {

    @ReceiverViewModel
    @Binds
    abstract fun bindReceiverViewModelFactory(receiverViewModelFactory: ReceiverViewModelFactory): ViewModelProvider.Factory
}