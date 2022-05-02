package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentProducerComponent {

    companion object {
        fun crete(
              activityComponent: MainActivityComponent
        ) = DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()

    }
    fun inject(fragment: FragmentProducer)

}