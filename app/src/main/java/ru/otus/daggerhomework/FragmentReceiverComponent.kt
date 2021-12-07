package ru.otus.daggerhomework

import dagger.Component

@Component(
    modules = [FragmentReceiverModule::class],
    dependencies = [MainActivityComponent::class]
)
@FragmentScope
interface FragmentReceiverComponent {

    fun injectReceiverDependencies(fragment: FragmentReceiver)

}