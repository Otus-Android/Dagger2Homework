package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Scope

@Scope
annotation class FragmentScope

@FragmentScope
@Component(
    modules = [ColorGeneratorModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}