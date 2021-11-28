package ru.otus.daggerhomework

import dagger.Component
import ru.otus.daggerhomework.qualifiers.FragmentScope

@FragmentScope
@Component(dependencies = [ApplicationComponent::class, MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: ApplicationComponent,
            mainActivityComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }
}

