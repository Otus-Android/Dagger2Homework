package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentComponent {
    fun inject(fragmentProducer: FragmentProducer)
    fun inject(fragmentReceiver: FragmentReceiver)
}