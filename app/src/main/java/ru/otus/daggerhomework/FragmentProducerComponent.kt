package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Scope

@Scope
annotation class FragmentScope

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [FragmentProducerModule::class])
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

}