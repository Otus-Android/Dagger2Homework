package ru.otus.daggerhomework.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Component
import dagger.Module

import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.ViewModelProducerFactory

@FragmentScope
@Component(dependencies = [MainActivityComponent::class],
        modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {
    companion object {
        fun getFragmentProducerComponent(mainActivityComponent: MainActivityComponent): FragmentProducerComponent =
            DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(mainActivityComponent)
                .build()
    }

    fun inject(fragmentProducer: FragmentProducer)
}

@Module
interface FragmentProducerModule {
    @Binds
    fun bindFactory(viewModelProducerFactory : ViewModelProducerFactory): ViewModelProvider.Factory

}