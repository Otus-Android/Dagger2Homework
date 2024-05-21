package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Scope

@ReceiverScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {
    fun inject(fragmentReceiver: FragmentReceiver)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ReceiverScope