package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentProducerComponent {

    companion object {

        fun init(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.factory()
                .create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}