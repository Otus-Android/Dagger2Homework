package ru.otus.daggerhomework.di.fragments

import dagger.Component
import kotlinx.coroutines.channels.SendChannel
import ru.otus.daggerhomework.ColorGenerator
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.LocalEvent
import ru.otus.daggerhomework.di.activity.ActivityComponent

@FragmentScope
@Component(
    modules = [FragmentProducerModule::class, FragmentProducerChannelModule::class],
    dependencies = [ActivityComponent::class]
)
interface FragmentProducerComponent {

    fun provideColorGenerator(): ColorGenerator

    fun provideSendChannel(): SendChannel<@JvmSuppressWildcards LocalEvent>

    fun inject(fragment: FragmentProducer)

    @Component.Builder
    interface FragmentProducerComponentBuilder {
        fun setActivityComponent(activityComponent: ActivityComponent): FragmentProducerComponentBuilder
        fun build(): FragmentProducerComponent
    }
}