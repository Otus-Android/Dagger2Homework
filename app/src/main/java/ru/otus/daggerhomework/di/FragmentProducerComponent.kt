package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.BindsProducerModule
import ru.otus.daggerhomework.ViewModelProviderFactory

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [BindsProducerModule::class])
interface FragmentProducerComponent {


    fun getViewModelFactory(): ViewModelProviderFactory

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}
