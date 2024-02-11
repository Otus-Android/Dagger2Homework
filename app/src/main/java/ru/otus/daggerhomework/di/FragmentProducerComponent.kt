package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.BindsProducerModule
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.StateFlowDependency
import ru.otus.daggerhomework.ViewModelProviderFactory

@Component(dependencies = [StateFlowDependency::class], modules = [BindsProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    fun getViewModelFactory(): ViewModelProviderFactory

    @Component.Factory
    interface Factory {
        fun create(stateFlowDependency: StateFlowDependency): FragmentProducerComponent
    }
}
