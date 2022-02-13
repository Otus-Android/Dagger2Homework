package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Scope

@Scope
annotation class FragmentScope

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {
    fun inject(fragment: FragmentReceiver)
}