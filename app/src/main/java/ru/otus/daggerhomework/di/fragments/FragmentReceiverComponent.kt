package ru.otus.daggerhomework.di.fragments

import dagger.Component
import kotlinx.coroutines.channels.ReceiveChannel
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.LocalEvent
import ru.otus.daggerhomework.di.activity.ActivityComponent

@FragmentScope
@Component(
    modules = [FragmentReceiverChannelModule::class],
    dependencies = [ActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    fun provideReceiveChannel(): ReceiveChannel<@JvmSuppressWildcards LocalEvent>

    @Component.Builder
    interface FragmentReceiverComponentBuilder {
        fun setActivityComponent(activityComponent: ActivityComponent): FragmentReceiverComponentBuilder
        fun build(): FragmentReceiverComponent
    }
}