package ru.otus.daggerhomework.receiver

import dagger.Component
import ru.otus.daggerhomework.ScopeFragment
import ru.otus.daggerhomework.main.MainActivityComponent

@ScopeFragment
@Component(
    dependencies = [MainActivityComponent::class]
)
interface FragmentReceiverComponent {

    fun inject(fragment: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: MainActivityComponent
        ): FragmentReceiverComponent
    }
}