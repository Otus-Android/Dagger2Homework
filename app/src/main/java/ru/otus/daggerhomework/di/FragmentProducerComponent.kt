package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    dependencies = [
        MainActivityComponent::class,
    ],
    modules = [
        ColorGeneratorModule::class
    ]
)
interface FragmentProducerComponent {

    fun inject(fragment: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityComponent: MainActivityComponent,
        ): FragmentProducerComponent
    }

}