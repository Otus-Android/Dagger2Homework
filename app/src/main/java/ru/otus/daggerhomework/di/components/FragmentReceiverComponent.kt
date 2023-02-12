package ru.otus.daggerhomework.di.components

import dagger.Component
import ru.otus.daggerhomework.FragmentReceiver
import ru.otus.daggerhomework.di.PerFragment

@Component(dependencies = [MainActivityComponent::class])
@PerFragment
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    companion object {
        fun createComponent(activityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()
        }
    }
}