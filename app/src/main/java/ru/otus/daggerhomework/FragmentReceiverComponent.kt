package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun getFragmentReceiverComponent(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(mainActivityComponent).build()
        }
    }
}