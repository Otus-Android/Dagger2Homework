package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.ui.producer.FragmentProducer
import ru.otus.daggerhomework.ui.receiver.FragmentReceiver

@Component(dependencies = [MainActivityComponent::class])
interface FragmentComponent {
    fun inject(fragmentProducer: FragmentProducer)
    fun inject(fragmentReceiver: FragmentReceiver)
}