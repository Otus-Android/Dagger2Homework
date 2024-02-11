package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.StateFlowDependency
import ru.otus.daggerhomework.ViewModelReceiverFactory

@Component(dependencies = [StateFlowDependency::class])
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)

    fun getViewModelFactory(): ViewModelReceiverFactory

    @Component.Factory
    interface Factory {
        fun create(stateFlowDependency: StateFlowDependency): FragmentReceiverComponent
    }
}
