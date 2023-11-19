package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.ui.FragmentProducer
import ru.otus.daggerhomework.di.scopes.FragmentScope

@FragmentScope
@Component(modules = [ViewModelModule::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    companion object {
        fun getFragmentProducerComponent(mainActivityComponent: MainActivityComponent): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.factory().create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent
    }
}