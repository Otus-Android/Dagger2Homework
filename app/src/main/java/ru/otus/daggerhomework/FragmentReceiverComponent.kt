package ru.otus.daggerhomework

import dagger.Component

@FragmentScope
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    companion object {

        fun init(
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.factory()
                .create(mainActivityComponent)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}