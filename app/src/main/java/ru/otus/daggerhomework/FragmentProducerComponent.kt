package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [MainActivityComponent::class],
    modules = [
        ViewModelProducerModule::class,
        UtilsModule::class
    ]
)
interface FragmentProducerComponent {
    fun inject(fragment: FragmentProducer)
    @Component.Factory
    interface FragmentProducerComponentFactory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}