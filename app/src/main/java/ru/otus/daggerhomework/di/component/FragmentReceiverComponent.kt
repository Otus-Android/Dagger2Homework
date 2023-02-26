package ru.otus.daggerhomework.di.component

import dagger.Component
import ru.otus.daggerhomework.di.PerFragment
import ru.otus.daggerhomework.fragments.FragmentReceiver

@Component(dependencies = [MainActivityComponent::class])
@PerFragment
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    companion object {
        fun create(activityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(activityComponent)
                .build()
        }
    }
}