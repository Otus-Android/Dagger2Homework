package ru.otus.daggerhomework.di.producer

import dagger.Component
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.producer.FragmentProducer
import ru.otus.daggerhomework.di.FragmentScope
import ru.otus.daggerhomework.di.main.MainActivityComponent

@FragmentScope
@Component(
    modules = [ProducerViewModelModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {

        fun create(activityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(target: FragmentProducer)
}