package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.ColorsController
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class],
)
interface FragmentProducerComponent {
    @Component.Factory
    interface Factory {
        fun create(
            activityComponent: ActivityComponent,
            @BindsInstance colorGenerator: ColorGenerator,
        ): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}