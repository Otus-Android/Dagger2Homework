package ru.otus.daggerhomework.producer

import dagger.Component
import ru.otus.daggerhomework.MainActivityComponent
import ru.otus.daggerhomework.di.FragmentScope


@Component(
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }

    fun inject(fragmentProducer: FragmentProducer)

}
