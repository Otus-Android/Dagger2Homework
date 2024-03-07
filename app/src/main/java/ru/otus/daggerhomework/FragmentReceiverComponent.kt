package ru.otus.daggerhomework

import dagger.Component

@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun getSubject(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder().mainActivityComponent(mainActivityComponent).build()
        }
    }
}