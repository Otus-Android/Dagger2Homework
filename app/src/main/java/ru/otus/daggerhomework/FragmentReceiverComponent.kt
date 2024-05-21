package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ViewModelReceiverModule::class]
)
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
    @Component.Factory
    interface FragmentReceiverComponentFactory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}