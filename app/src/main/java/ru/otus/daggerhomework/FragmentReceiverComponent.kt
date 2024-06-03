package ru.otus.daggerhomework

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope

@ReceiverScope
@Component(
    modules = [FragmentReceiverModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
}

@Module
interface FragmentReceiverModule {
    @Binds
    fun bindsEventsObserver(eventsObserverImpl: EventsObserverImpl): EventsObserver
}


@Scope
annotation class ReceiverScope