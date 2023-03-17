package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [ApplicationComponent::class]
)
interface FragmentProducerComponent {

    companion object {

        fun init(
            applicationComponent: ApplicationComponent
        ): FragmentProducerComponent {
            return DaggerFragmentProducerComponent.factory()
                .create(applicationComponent)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}