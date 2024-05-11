package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    modules = [FragmentProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)
}
