package ru.otus.daggerhomework.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.otus.daggerhomework.FragmentProducer


@FragmentScope
@Component(
    dependencies = [ActivityComponent::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}