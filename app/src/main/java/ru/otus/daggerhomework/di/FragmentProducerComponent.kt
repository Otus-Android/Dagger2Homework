package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer

@Component(
    modules = [ViewModelProducerModule::class],
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentProducerComponent {
    companion object {
        fun getInstance(activityComponent: MainActivityComponent): FragmentProducerComponent =
            DaggerFragmentProducerComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()
    }

    fun inject(fragment: FragmentProducer)
}


