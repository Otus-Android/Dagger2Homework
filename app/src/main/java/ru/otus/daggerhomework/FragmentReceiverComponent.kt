package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [ActivityComponent::class], modules = [FragmentReceiverModule::class])
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

}