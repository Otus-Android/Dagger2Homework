package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    modules = [ColorGeneratorModule::class],
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}