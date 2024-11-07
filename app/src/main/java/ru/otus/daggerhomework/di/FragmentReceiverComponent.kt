package ru.otus.daggerhomework.di

import dagger.Component
import dagger.Module
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.ViewModelReceiver

@FragmentScope
@Component(
    dependencies = [ActivityComponent::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {
    @Component.Factory
    interface Factory {
        fun create(activityComponent: ActivityComponent): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}

@Module(includes = [FragmentProducerModule::class])
interface FragmentReceiverModule {
    @FragmentScope
    fun getViewModel(): ViewModelReceiver
}