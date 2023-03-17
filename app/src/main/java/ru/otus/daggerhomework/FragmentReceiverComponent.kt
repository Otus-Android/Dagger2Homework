package ru.otus.daggerhomework

import dagger.Component

@Component(
    dependencies = [ApplicationComponent::class]
)
interface FragmentReceiverComponent {

    companion object {

        fun init(
            applicationComponent: ApplicationComponent
        ): FragmentReceiverComponent {
            return DaggerFragmentReceiverComponent.factory()
                .create(applicationComponent)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent
        ): FragmentReceiverComponent
    }

    fun inject(fragment: FragmentReceiver)
}