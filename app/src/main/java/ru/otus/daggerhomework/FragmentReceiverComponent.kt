package ru.otus.daggerhomework

import dagger.Component
import dagger.Module

@FragmentScope
@Component(
    modules = [FragmentReceiverModule::class],
    dependencies = [MainActivityComponent::class],
)
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}

@Module
interface FragmentReceiverModule {

}