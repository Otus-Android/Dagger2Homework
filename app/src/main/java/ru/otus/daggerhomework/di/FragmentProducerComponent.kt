package ru.otus.daggerhomework.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.ColorGeneratorImpl
import ru.otus.daggerhomework.FragmentProducer

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [FragmentProducerModule::class]
)
interface FragmentProducerComponent {

    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentProducerComponent
    }

    fun inject(fragment: FragmentProducer)
}

@Module
interface FragmentProducerModule {
    @Binds
    fun provideColorGenerator(colorGenerator: ColorGeneratorImpl): ColorGenerator
}