package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.GenerateModule

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [GenerateModule::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
    @FragmentScope
    fun inject(fragmentProducer: FragmentProducer)

}