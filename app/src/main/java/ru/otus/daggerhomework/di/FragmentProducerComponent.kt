package ru.otus.daggerhomework.di


import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(modules = [ProducerModule::class, ProducerModule2::class], dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Builder
    interface Builder {

        fun mainComponent(mainActivityComponent: MainActivityComponent): Builder

        fun build(): FragmentProducerComponent
    }
}