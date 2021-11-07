package ru.otus.daggerhomework.di

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class, MainActivityComponent::class],
    modules = [FragmentReceiverModule::class]
)
interface FragmentReceiverComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent,
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}