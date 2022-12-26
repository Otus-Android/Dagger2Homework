package ru.otus.daggerhomework.components

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.modules.ReceiverCacheModule
import ru.otus.daggerhomework.scopes_and_qualifiers.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [ReceiverCacheModule::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}