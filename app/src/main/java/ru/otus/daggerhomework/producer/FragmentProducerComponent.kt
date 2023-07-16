package ru.otus.daggerhomework.producer

import dagger.Component
import ru.otus.daggerhomework.activity.MainActivityComponent
import ru.otus.daggerhomework.di.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Component.Builder
    interface Builder {

        fun mainActivityComponent(mainActivityComponent: MainActivityComponent): Builder

        fun build(): FragmentProducerComponent
    }
}