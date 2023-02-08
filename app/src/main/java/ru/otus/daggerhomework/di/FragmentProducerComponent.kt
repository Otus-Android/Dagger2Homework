package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Component
import ru.otus.daggerhomework.*

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    //fun provideEventBus(): EventBus

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

}