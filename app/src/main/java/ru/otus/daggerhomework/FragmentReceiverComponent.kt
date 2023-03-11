package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [
        MainActivityComponent::class
    ]
)
@FragmentScope
interface FragmentReceiverComponent {
    fun providesColorProvider(): ColorProvider
    fun inject(fragmentReceiver: FragmentReceiver)

    companion object {
        fun inject(fragmentReceiver: FragmentReceiver) =
            DaggerFragmentReceiverComponent.builder()
                .mainActivityComponent(fragmentReceiver.requireActivity().requireMainActivityComponent())
                .build()
                .inject(fragmentReceiver)
    }
}