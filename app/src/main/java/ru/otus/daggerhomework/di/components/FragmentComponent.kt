package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.FragmentProducer
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.scopes.FragmentScope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentComponent {
    fun inject(fragmentProducer: FragmentProducer)
    fun inject(fragmentReceiver: FragmentReceiver)
}