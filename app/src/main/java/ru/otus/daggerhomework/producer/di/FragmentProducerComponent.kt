package ru.otus.daggerhomework.producer.di

import dagger.Component
import ru.otus.daggerhomework.FragmentScope
import ru.otus.daggerhomework.activity.di.MainActivityComponent
import ru.otus.daggerhomework.producer.FragmentProducer


@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }
}